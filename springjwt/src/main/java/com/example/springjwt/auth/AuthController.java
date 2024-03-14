package com.example.springjwt.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, PasswordEncoder passwordEncoder, CustomUserDetailsService customUserDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @PostMapping("/api/auth/login")
    public String login() {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("demo", "123456"));
        String email = authentication.getName();
        System.out.println("Email=" + email);
        return this.jwtService.generateToken(customUserDetailsService.loadUserByUsername("demo"));
    }

}
