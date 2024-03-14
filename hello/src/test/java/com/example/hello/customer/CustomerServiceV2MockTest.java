package com.example.hello.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustomerServiceV2MockTest {

    @Autowired
    private CustomerService customerServiceV2;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("Success with valid input")
    void case01() {
        // Arrange
        // Mock
        when(customerRepository.findByFname("somkiat"))
                .thenReturn(Optional.of(new Customer()));

        CustomerCreateRequest request = new CustomerCreateRequest();
        request.setFname("somkiat");
        request.setLname("pui");
        // Act
        // In Junit 5
        Exception exception = assertThrows(RuntimeException.class, () ->
                customerServiceV2.process(request));
        assertEquals("User = somkiat existed", exception.getMessage());
    }
}