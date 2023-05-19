package com.ncc.service;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
