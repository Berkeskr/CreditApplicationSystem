package com.example.creditapplicationsystem.service;

import org.springframework.stereotype.Service;

@Service
public class ConfirmationService {

    private static final int creditLimitFactor=4;

    public String status(int creditScore){
        if(creditScore<500){
            return "Rejected!";
        }else {
            return "Accepted";
        }

    }

    public int calculateLimit(int creditScore, double salary){
        if(creditScore<500){
            return 0;
        }else if(creditScore<1000){
            if (salary<5000.0){
                return 10000;
            }else{
                return 20000;
            }
        }else{
            return (int) (salary*creditLimitFactor);
        }
    }

}
