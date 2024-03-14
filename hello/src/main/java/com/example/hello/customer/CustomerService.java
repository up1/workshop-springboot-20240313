package com.example.hello.customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface CustomerService {
    public void process();
}

@Component
class CustomerServiceV1 implements CustomerService {
    public void process() {
        System.out.println("Call customer service v1");
    }
}

@Component
class CustomerServiceV2 implements CustomerService {
    public void process() {
        System.out.println("Call customer service v2");
    }
}
