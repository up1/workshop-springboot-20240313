package com.example.hello.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserGatewayTest {

    @Autowired
    private UserGateway userGateway;

    @Test
    void callUserById() {
        // Act
        Optional<UserResponse> response = userGateway.callUserById(1);
        // Assert
        assertTrue(response.isPresent());
        assertEquals(1, response.get().getId());
        assertEquals("Sincere@april.biz", response.get().getEmail());
    }
}