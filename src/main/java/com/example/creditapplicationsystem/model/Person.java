package com.example.creditapplicationsystem.model;

import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@Data
@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @NotBlank(message = "name cannot be null")
    private String name;
    @NotBlank(message = "surname cannot be null")
    private String surname;

}
