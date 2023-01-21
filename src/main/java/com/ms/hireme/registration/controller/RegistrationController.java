package com.ms.hireme.registration.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.hireme.registration.dto.RegistrationDTO;
import com.ms.hireme.registration.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    
    @Autowired
    private RegistrationService service;


    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDTO> getRegistrationById(@PathVariable UUID id){
        RegistrationDTO registration = service.getRegistrationById(id);
        return ResponseEntity.ok().body(registration);
    }
}
