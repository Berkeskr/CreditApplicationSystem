package com.example.creditapplicationsystem.model.dto;

import com.example.creditapplicationsystem.model.Customer;
import lombok.Data;

@Data
public class ApplicationDTO {
    private long referenceNumber;
    private String status;
    private int creditLimit;
    private CustomerDTO customerDTO;
}
