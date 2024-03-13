package com.example.hello.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("ทำการทดสอบดึงข้อมูล customer ทั้งหมดขึ้นมาดู ต้อง success นะ")
    void getAllCustomer() {
        // Act
        List response = restTemplate.getForObject("/customer", List.class);
        // Assert
        assertEquals(3, response.size());
    }

    @Test
    void getCustomerById() {
        // Act
        CustomerResponse response = restTemplate.getForObject("/customer/1", CustomerResponse.class);
        // Assert
        assertEquals(1, response.getId());
        assertEquals("somkiat pui", response.getFull_name());
    }

    @Test
    void getCustomerByIdWith404() {
        // Act
        ErrorResponse response = restTemplate.getForObject("/customer/2", ErrorResponse.class);
        // Assert
        assertEquals("Customer id=2 not found", response.getMessage());
    }

    @Test
    void getCustomerByIdWith500() {
        // Act
        ResponseEntity<ErrorResponse> response = restTemplate.getForEntity("/customer/3", ErrorResponse.class);
        // Assert
        assertEquals(500, response.getStatusCode().value());
        assertEquals("Error", response.getBody().getMessage());
    }
}