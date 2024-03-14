package com.example.hello.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void createNewCustomer_success() {
        // Arrange
        Customer customer = new Customer();
        customer.setFname("Demo fname");
        customer.setLname("Demo lname");
        // Act
        Customer newCustomer = customerRepository.save(customer);
        // Assert
        assertTrue(newCustomer.getId() > 0);
        assertEquals("Demo fname", newCustomer.getFname());
        assertEquals("Demo lname", newCustomer.getLname());
    }

    @Test
    @DisplayName("ไม่สามารถสร้าง customer ได้เนื่องจากชื่อซ้ำ")
    public void case02(){
        // Arrange
        Customer customer = new Customer();
        customer.setFname("somkiat");
        customer.setLname("Demo lname");
        customerRepository.save(customer);
        // Act
        Optional<Customer> result
                = customerRepository.findByFname("somkiat");
        // Assert
        assertTrue(result.isPresent());
    }

}