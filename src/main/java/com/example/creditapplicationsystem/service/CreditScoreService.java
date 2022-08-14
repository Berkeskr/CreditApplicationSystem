package com.example.creditapplicationsystem.service;

import org.springframework.stereotype.Service;

@Service
public class CreditScoreService {
    private static final int min=0;
    private static final int max=2000;

    public int getCreditScore(){
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }
}
