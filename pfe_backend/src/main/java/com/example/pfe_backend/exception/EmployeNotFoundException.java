package com.example.pfe_backend.exception;

public class EmployeNotFoundException extends RuntimeException {
    public EmployeNotFoundException(String message) {
        super(message);
    }
}

