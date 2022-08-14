package com.example.creditapplicationsystem.service;

import com.example.creditapplicationsystem.model.Application;
import com.example.creditapplicationsystem.model.Customer;
import com.example.creditapplicationsystem.model.dto.ApplicationDTO;
import com.example.creditapplicationsystem.model.mapper.ApplicationMapper;
import com.example.creditapplicationsystem.repository.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepo applicationRepo;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ConfirmationService confirmationService;

    public ApplicationDTO applyForCredit(String customerSSN){
        Customer customer = customerService.getCustomerBySSN(customerSSN);


        Application application=new Application();
        application.setCustomer(customer);
        application.setCreditLimit(confirmationService.calculateLimit(customer.getCreditScore(),customer.getSalary()));
        application.setStatus(confirmationService.status(customer.getCreditScore()));
        applicationRepo.save(application);
        ApplicationDTO applicationDTO = ApplicationMapper.toDTO(application);
        return applicationDTO;

    }

    public List<ApplicationDTO> trackApplication(String SSN){
        Customer customer = customerService.getCustomerBySSN(SSN);
        return customer.getApplication().
                stream().map(ApplicationMapper::toDTO)
                .collect(Collectors.toList());

    }
}