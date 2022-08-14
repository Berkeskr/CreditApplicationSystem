package com.example.creditapplicationsystem.model.mapper;

import com.example.creditapplicationsystem.model.Application;
import com.example.creditapplicationsystem.model.dto.ApplicationDTO;

public class ApplicationMapper {

    public static ApplicationDTO toDTO(Application application){
        ApplicationDTO applicationDTO=new ApplicationDTO();

        applicationDTO.setStatus(application.getStatus());
        applicationDTO.setCreditLimit(application.getCreditLimit());
        applicationDTO.setCustomerDTO(CustomerMapper.toDTO(application.getCustomer()));
        applicationDTO.setReferenceNumber(application.getReferenceNumber());
        return applicationDTO;
    }
}
