package com.example.creditapplicationsystem.exception;

public class CustomerAlreadyExist extends RuntimeException{
    public CustomerAlreadyExist(String message) {
        super(message);
    }
}
