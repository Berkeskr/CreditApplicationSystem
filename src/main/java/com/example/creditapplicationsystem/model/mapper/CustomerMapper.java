package com.example.creditapplicationsystem.model.mapper;

import com.example.creditapplicationsystem.model.Customer;
import com.example.creditapplicationsystem.model.dto.CustomerDTO;

public class CustomerMapper {

    public static CustomerDTO toDTO(Customer customer){
        CustomerDTO customerDTO=new CustomerDTO();

        customerDTO.setSSN(customer.getSSN());
        customerDTO.setName(customer.getName());
        customerDTO.setSurname(customer.getSurname());
        return customerDTO;
    }

    public static Customer toEntity(CustomerDTO customerDTO){
        Customer customer=new Customer();

        customer.setSSN(customerDTO.getSSN());
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        return customer;
    }
}
