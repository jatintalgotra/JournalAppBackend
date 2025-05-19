package com.jatintalgotra.e2e_journal_app.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HealthCheck {
     
    
    @GetMapping("/Check")
    public String check(){
        return "Ok";
    }
}
