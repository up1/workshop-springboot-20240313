package com.example.hello.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("")
    public String getAllCustomer(){
        return "Hello Get all customer";
    }

    @GetMapping("/{id}")
    public String getCustomerById(@PathVariable int id) {
        return "Get customer by id=" + id;
    }

}
