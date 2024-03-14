package com.example.hello.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
        assertEquals(1, newCustomer.getId());
        assertEquals("Demo fname", newCustomer.getFname());
        assertEquals("Demo lname", newCustomer.getLname());
    }

}