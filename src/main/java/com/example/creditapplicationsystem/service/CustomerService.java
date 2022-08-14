package com.example.creditapplicationsystem.service;

import com.example.creditapplicationsystem.exception.CustomerAlreadyExist;
import com.example.creditapplicationsystem.exception.CustomerNotFound;
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
    @Autowired
    private CreditScoreService creditScoreService;

    public List<Customer> getAllCustomers(){
        List<Customer> allCustomers = customerRepo.findAll();
        return allCustomers;
    }

    public Customer getCustomerBySSN(String SSN){
        Customer bySSN = customerRepo.findBySSN(SSN);
        if (bySSN==null){
            throw new CustomerNotFound("Customer with SSN:"+SSN+" not found!");
        }
        return bySSN;
    }


    public Customer createCustomer(Customer customer){
        Customer bySSN = customerRepo.findBySSN(customer.getSSN());
        if (bySSN==null){
            customer.setCreditScore(creditScoreService.getCreditScore());
            return customerRepo.save(customer);
        }else throw new CustomerAlreadyExist("Customer already exist!");


    }

    public void deleteCustomerBySSN(String SSN){
        getCustomerBySSN(SSN);
        customerRepo.deleteBySSN(SSN);
    }

    public Customer updateCustomer(String ssn, Customer customer){
        Customer existingCustomer = getCustomerBySSN(ssn);
        existingCustomer.setSSN(customer.getSSN());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        existingCustomer.setSalary(customer.getSalary());
        existingCustomer.setName(customer.getName());
        existingCustomer.setSurname(customer.getSurname());

        return customerRepo.save(existingCustomer);
    }
}
