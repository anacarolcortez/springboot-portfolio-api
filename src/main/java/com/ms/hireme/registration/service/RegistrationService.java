package com.ms.hireme.registration.service;

import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.hireme.registration.dto.RegistrationDTO;
import com.ms.hireme.registration.model.Registration;
import com.ms.hireme.registration.repository.RegistrationRepository;
import com.ms.hireme.utils.exceptions.DataBaseException;
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

    @Transactional
    public RegistrationDTO createRegistration(RegistrationDTO regDto){
        Registration registration = new Registration();
        convertDtoToEntity(regDto, registration);
        registration = repository.save(registration);
        return new RegistrationDTO(registration);
    }

    @Transactional
    public RegistrationDTO updtaeRegistration(UUID id, RegistrationDTO regDto){
        try{
            Registration registration = repository.getReferenceById(id);
            convertDtoToEntity(regDto, registration);
            registration = repository.save(registration);
            return new RegistrationDTO(registration);
        } catch (EntityNotFoundException err){
            throw new ResourceNotFoundException("Id not found" + id);
        }
    }

    public void delete(UUID id){
        try{
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException err){
            throw new ResourceNotFoundException("Id not found" + id);
        } catch (DataIntegrityViolationException err) {
            throw new DataBaseException("Integrity violation");
        }
    }

    private void convertDtoToEntity(RegistrationDTO dto, Registration entity){
        if(dto.getEmail() != null && !dto.getEmail().isEmpty()){
            entity.setEmail(dto.getEmail());
        }
        
        if(dto.getCompany() != null && !dto.getCompany().isEmpty()) {
            entity.setCompany(dto.getCompany());
        }
        
        if(dto.getJobTitle() != null && !dto.getJobTitle().isEmpty()) {
            entity.setJobTitle(dto.getJobTitle());
        }

        if(dto.getName() != null && !dto.getName().isEmpty()) {
            entity.setName(dto.getName());
        }

        if(dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            entity.setPassword(dto.getPassword());
        }

    }
}
