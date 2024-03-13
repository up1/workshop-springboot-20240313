package com.example.hello.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/customer")
    public String getAllCustomer(){
        return "Hello Get all customer";
    }

    @GetMapping("/customer/{id}")
    public String getCustomerById(@PathVariable int id) {
        return "Get customer by id=" + id;
    }

}
