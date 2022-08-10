package com.example.creditapplicationsystem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long referenceNumber;

    private String status;
    private int creditLimit;
    @OneToOne
    @JoinColumn(name = "customer")
    private Customer customer;
}
