package com.example.hello.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class UserGateway {

    @Autowired
    private RestTemplate restTemplate;

    public Optional<UserResponse> callUserById(int id) {
        String url = "http://localhost:9999/users/" + id;
        UserResponse response = restTemplate.getForObject(url, UserResponse.class);
        return  Optional.of(response);
    }

}
