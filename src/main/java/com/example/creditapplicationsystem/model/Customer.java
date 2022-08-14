package com.example.creditapplicationsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Entity
public class Customer extends Person {

    @NotBlank(message = "social security number cannot be null")
    @Pattern(regexp = "[0-9]{11}",message = "social security number should be 11 digits")
    private String SSN; //Social Security Number

    @Pattern(regexp = "[0-9]{11}",message = "phone number should be 11 digits (including leading 0)")
    private String phoneNumber;

    @Min(value = 1,message = "salary cannot be null")
    private double Salary;

    private int creditScore; //Generated randomly

    @OneToMany(mappedBy = "customer")
    @JsonIgnore //to avoid infinite recursion
    private List<Application> application;
}

// TODO: SSN must be 11 digits, so apply regex
// TODO: phoneNumber must have a pattern
