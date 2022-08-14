package com.example.creditapplicationsystem.repository;

import com.example.creditapplicationsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository <Customer,Long>{
    Customer findBySSN(String SSN);
    void deleteBySSN(String SSN);
}
