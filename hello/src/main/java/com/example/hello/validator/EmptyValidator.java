package com.example.hello.validator;

import org.springframework.stereotype.Component;

@Component
public class EmptyValidator implements MyValidator {
    @Override
    public void validate(String input) {
        if(input == null || input.trim().isEmpty()) {
            throw new RuntimeException();
        }
    }
}
