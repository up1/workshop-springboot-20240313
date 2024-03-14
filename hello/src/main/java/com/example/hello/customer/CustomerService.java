package com.example.hello.customer;

import org.springframework.stereotype.Component;

import java.util.Optional;

public interface CustomerService {
    public CustomerResponse process(CustomerCreateRequest request);
}

@Component
class CustomerServiceV1 implements CustomerService {
    public CustomerResponse process(CustomerCreateRequest request) {
        System.out.println("Call customer service v1");
        return null;
    }
}

@Component
class CustomerServiceV2 implements CustomerService {

    private final CustomerRepository customerRepository;

    CustomerServiceV2(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse process(CustomerCreateRequest request) {
        System.out.println("Call customer service v2");
        // 1. Check firstname
        Optional<Customer> result = customerRepository.findByFname(request.getFname());
        if (result.isPresent()) {
            throw new RuntimeException("User = " + request.getFname() + " existed");
        }
        // 2. Insert data to customer table
        Customer customer = new Customer();
        customer.setFname(request.getFname());
        customer.setLname(request.getLname());
        Customer newCustomer = customerRepository.save(customer);
        // 3. Return new customer info
        CustomerResponse response = new CustomerResponse();
        response.setId(customer.getId());
        response.setFull_name(newCustomer.getFname() + " " + newCustomer.getLname());
        return response;
    }
}
