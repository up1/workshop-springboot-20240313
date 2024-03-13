package com.example.hello.customer;

public class BusinessException extends RuntimeException {
    public BusinessException(String error) {
        super(error);
    }
}
