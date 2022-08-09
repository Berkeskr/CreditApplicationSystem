package com.example.creditapplicationsystem.controller;

import com.example.creditapplicationsystem.model.Customer;
import com.example.creditapplicationsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@Validated
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity getAllCustomers(){
        List<Customer> allCustomers = customerService.getAllCustomers();
        return ResponseEntity.ok(allCustomers);
    }
    @GetMapping("/customer/{SSN}")
    public ResponseEntity getCustomerBySSN(@PathVariable Long SSN){
        Customer customerBySSN = customerService.getCustomerBySSN(SSN);
        return ResponseEntity.ok(customerBySSN);
    }
    @PostMapping("/customer")
    public ResponseEntity createCustomer(@RequestBody Customer customer){
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }
    @DeleteMapping("/customer/{SSN}")
    public ResponseEntity deleteCustomerBySSN(@PathVariable(name = "SSN") Long SSN){
        customerService.deleteCustomerBySSN(SSN);
        return ResponseEntity.ok("Customer Deleted");
    }
    @PutMapping("/customer/{SSN}")
    public ResponseEntity updateCustomerBySSN(@PathVariable(name = "SSN") Long ssn,@RequestBody Customer customer){
        Customer updatedCustomer = customerService.updateCustomer(ssn, customer);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCustomer);
    }
}
