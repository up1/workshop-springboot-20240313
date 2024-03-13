package com.example.hello.customer;

import com.example.hello.validator.EmptyValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.valueOf;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private EmptyValidator emptyValidator;

    private void validateInput(CustomerCreateRequest request) {
        if(request != null) {
            emptyValidator.validate(request.getFname());
            emptyValidator.validate(request.getLname());
        }
        throw new RuntimeException();
    }

    @PostMapping("")
    public ResponseEntity<CustomerResponse> createNewCustomer(
           @Valid @RequestBody CustomerCreateRequest request) {
        System.out.println(request);
        // Validation
//        validateInput(request);
        // Create response
        CustomerResponse response = new CustomerResponse();
        response.setId(123);
        response.setFull_name( request.getFname() + " " + request.getLname() );
        return new ResponseEntity<>(response, valueOf(201));
    }

    @GetMapping("")
    public List<CustomerResponse> getAllCustomer(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "5") int size){
        System.out.println("Page = " + page);
        System.out.println("Size = " + size);
        List<CustomerResponse> responses = new ArrayList<>();
        responses.add(new CustomerResponse());
        responses.add(new CustomerResponse());
        responses.add(new CustomerResponse());
        return responses;
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomerById(@PathVariable int id) {
        if(id == 2) {
            // 404
            throw new CustomerNotFoundException("Customer id=" + id + " not found");
        }
        if(id == 3) {
            // 500
            throw new BusinessException("Error");
        }

        CustomerResponse response = new CustomerResponse();
        response.setId(id);
        response.setFull_name("somkiat pui");
        return  response;
    }

}
