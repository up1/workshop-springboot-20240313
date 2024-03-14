package com.example.hello.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustomerServiceV2Test {

    @Autowired
    private CustomerService customerServiceV2;

    @Test
    @DisplayName("Success with valid input")
    void case01() {
        // Arrange
        CustomerCreateRequest request = new CustomerCreateRequest();
        request.setFname("somkiat2");
        request.setLname("pui");
        // Act
        CustomerResponse response = customerServiceV2.process(request);
        // Assert
        assertTrue(response.getId() > 0);
        assertEquals("somkiat2 pui", response.getFull_name());
    }
}