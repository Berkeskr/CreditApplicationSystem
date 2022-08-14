package com.example.creditapplicationsystem.controller;

import com.example.creditapplicationsystem.model.dto.ApplicationDTO;
import com.example.creditapplicationsystem.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/application/{SSN}")
    public ResponseEntity trackApplication(@PathVariable(name = "SSN") String SSN){
        List<ApplicationDTO> applicationDTOList = applicationService.trackApplication(SSN);
        return ResponseEntity.ok(applicationDTOList);
    }

    @PostMapping("/apply/{SSN}")
    public ResponseEntity applyForCredit(@PathVariable(name = "SSN") String SSN){
        ApplicationDTO applicationDTO = applicationService.applyForCredit(SSN);
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationDTO);
    }
}
