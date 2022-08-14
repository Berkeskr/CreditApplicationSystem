package com.example.creditapplicationsystem.repository;

import com.example.creditapplicationsystem.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepo extends JpaRepository<Application,Long> {

}
