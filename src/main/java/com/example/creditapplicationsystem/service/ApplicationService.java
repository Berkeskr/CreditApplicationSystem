package com.example.creditapplicationsystem.service;

import com.example.creditapplicationsystem.model.Application;
import com.example.creditapplicationsystem.model.Customer;
import com.example.creditapplicationsystem.model.dto.ApplicationDTO;
import com.example.creditapplicationsystem.model.mapper.ApplicationMapper;
import com.example.creditapplicationsystem.repository.ApplicationRepo;
import com.example.creditapplicationsystem.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepo applicationRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ConfirmationService confirmationService;

    public ApplicationDTO applyForCredit(String customerSSN){
        Customer customer = customerRepo.findBySSN(customerSSN);


        Application application=new Application();
        application.setCustomer(customer);
        application.setCreditLimit(confirmationService.calculateLimit(customer.getCreditScore(),customer.getSalary()));
        application.setStatus(confirmationService.status(customer.getCreditScore()));
        applicationRepo.save(application);
        ApplicationDTO applicationDTO = ApplicationMapper.toDTO(application);
        return applicationDTO;

    }

    public ApplicationDTO trackApplication(String SSN){
        Customer customer = customerRepo.findBySSN(SSN);
        return ApplicationMapper.toDTO(customer.getApplication());

    }
}