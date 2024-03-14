package com.example.springjwt.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public User findUserByEmail(String email){
        User user = new User(email,"$2a$10$tcATXcqhwtRkDfB21ulGq.KozN3.DP2q4Q9rjhqbypwmbQAbpUHJe");
        user.setFirstName("Demo firstname");
        user.setLastName("Demo lastname");
        return user;
    }
}
