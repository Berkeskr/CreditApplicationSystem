package com.example.creditapplicationsystem.exception.handler;

import com.example.creditapplicationsystem.exception.AdminNotFound;
import com.example.creditapplicationsystem.exception.CustomerAlreadyExist;
import com.example.creditapplicationsystem.exception.CustomerNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity constraint(ConstraintViolationException constraintViolationException){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(constraintViolationException.getMessage());
    }
    @ExceptionHandler(AdminNotFound.class)
    public ResponseEntity adminNotFoundException(AdminNotFound adminNotFound){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(adminNotFound.getMessage());
    }
    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity customerNotFoundException(CustomerNotFound customerNotFound){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customerNotFound.getMessage());
    }
    @ExceptionHandler(CustomerAlreadyExist.class)
    public ResponseEntity customerAlreadyExistException(CustomerAlreadyExist customerAlreadyExist){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(customerAlreadyExist.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity exception(Exception exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }
}
