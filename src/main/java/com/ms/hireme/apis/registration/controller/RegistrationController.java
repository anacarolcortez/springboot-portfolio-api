package com.ms.hireme.apis.registration.controller;

import java.net.URI;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ms.hireme.apis.registration.dto.RegistrationCreateDTO;
import com.ms.hireme.apis.registration.dto.RegistrationDTO;
import com.ms.hireme.apis.registration.dto.RegistrationUpdateDTO;
import com.ms.hireme.apis.registration.service.RegistrationService;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {
    
    @Autowired
    private RegistrationService service;


    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDTO> getRegistrationById(@PathVariable UUID id){
        RegistrationDTO registration = service.getRegistrationById(id);
        return ResponseEntity.ok().body(registration);
    }

    @PostMapping()
    public ResponseEntity<RegistrationCreateDTO> createRegistration(@Valid @RequestBody RegistrationCreateDTO registrationDTO){
        RegistrationCreateDTO registration = service.createRegistration(registrationDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(registration.getId())
                .toUri();
        return ResponseEntity.created(uri).body(registration);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RegistrationUpdateDTO> updateRegistrationById(@PathVariable UUID id, @Valid @RequestBody RegistrationUpdateDTO registrationDTO){
        RegistrationUpdateDTO registration = service.updateRegistration(id, registrationDTO);
        return ResponseEntity.ok().body(registration);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistrationById(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
