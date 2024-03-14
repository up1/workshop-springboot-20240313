package com.example.hello;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // SCOPE = SINGLETON
public class MyBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
