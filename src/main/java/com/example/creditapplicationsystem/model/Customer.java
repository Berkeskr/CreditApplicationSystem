package com.example.creditapplicationsystem.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Customer extends User{
    @Column(nullable = false)
    //@NotNull is not working, why ?
    private Long SSN; //Social Security Number

    private Double Salary;
    private Long phoneNumber;
    private Long creditScore;
}

// TODO: SSN must be 11 digits, so apply regex
// TODO: phoneNumber must have a pattern
