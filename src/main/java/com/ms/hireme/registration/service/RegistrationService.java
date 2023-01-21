package com.ms.hireme.registration.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.hireme.registration.dto.RegistrationDTO;
import com.ms.hireme.registration.model.Registration;
import com.ms.hireme.registration.repository.RegistrationRepository;
import com.ms.hireme.utils.exceptions.ResourceNotFoundException;

@Service
public class RegistrationService {
    
    @Autowired
    private RegistrationRepository repository;

    @Transactional(readOnly = true)
    public RegistrationDTO getRegistrationById(UUID id){
        Optional<Registration> entity = repository.findById(id);
        Registration registration = entity.orElseThrow(() -> new ResourceNotFoundException("Registration id not found: " + id));
        return new RegistrationDTO(registration);
    }
}
