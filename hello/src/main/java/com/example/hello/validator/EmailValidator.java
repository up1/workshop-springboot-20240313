package com.example.hello.validator;

public class EmailValidator implements MyValidator {
    @Override
    public void validate(String input) {
        if(input == null || input.trim().isEmpty()) {
            throw new RuntimeException();
        }
    }
}
