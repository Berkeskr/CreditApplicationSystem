package com.example.creditapplicationsystem.service;

import com.example.creditapplicationsystem.model.Customer;
import com.example.creditapplicationsystem.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> getAllCustomers(){
        List<Customer> allCustomers = customerRepo.findAll();
        return allCustomers;
    }

    public Customer getCustomerBySSN(Long SSN){
        Customer customer = customerRepo.findBySSN(SSN);
        return customer;
    }


    public Customer createCustomer(Customer customer){
        return customerRepo.save(customer);

    }

    public void deleteCustomerBySSN(Long SSN){
        customerRepo.deleteBySSN(SSN);
    }

    public Customer updateCustomer(Long ssn, Customer customer){
        Customer existingCustomer = customerRepo.findBySSN(ssn);
        existingCustomer.setSSN(customer.getSSN());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        existingCustomer.setSalary(customer.getSalary());
        existingCustomer.setName(customer.getName());
        existingCustomer.setSurname(customer.getSurname());

        return customerRepo.save(existingCustomer);
    }
}
