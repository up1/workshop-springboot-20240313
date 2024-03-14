package com.example.hello;

import org.springframework.stereotype.Component;

@Component
public class MyBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
