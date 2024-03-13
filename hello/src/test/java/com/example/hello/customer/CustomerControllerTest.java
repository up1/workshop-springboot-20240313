package com.example.hello.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("ทำการทดสอบดึงข้อมูล customer ทั้งหมดขึ้นมาดู ต้อง success นะ")
    void getAllCustomer() {
        // Act
        String response = restTemplate.getForObject("/customer", String.class);
        // Assert
        assertEquals("Hello Get all customer", response);
    }

    @Test
    void getCustomerById() {
        // Act
        CustomerResponse response = restTemplate.getForObject("/customer/1", CustomerResponse.class);
        // Assert
        assertEquals(1, response.getId());
        assertEquals("somkiat pui", response.getFull_name());
    }
}