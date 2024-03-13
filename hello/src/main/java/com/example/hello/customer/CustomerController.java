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
    public CustomerResponse getCustomerById(@PathVariable int id) {
        CustomerResponse response = new CustomerResponse();
        response.setId(id);
        response.setFull_name("somkiat pui");
        return  response;
    }

}
