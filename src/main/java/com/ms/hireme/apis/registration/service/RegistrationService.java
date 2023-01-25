package com.ms.hireme.apis.registration.service;

import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.hireme.apis.registration.dto.RegistrationCreateDTO;
import com.ms.hireme.apis.registration.dto.RegistrationDTO;
import com.ms.hireme.apis.registration.dto.RegistrationUpdateDTO;
import com.ms.hireme.apis.registration.model.Registration;
import com.ms.hireme.apis.registration.repository.RegistrationRepository;
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
    public RegistrationCreateDTO createRegistration(RegistrationCreateDTO regDto){
        Registration registration = new Registration();
        regDto.convertDtoToEntity(regDto, registration);
        registration = repository.save(registration);
        return new RegistrationCreateDTO(registration);
    }

    @Transactional
    public RegistrationUpdateDTO updateRegistration(UUID id, RegistrationUpdateDTO regDto){
        try{
            Registration registration = repository.getReferenceById(id);
            regDto.convertDtoToEntity(regDto, registration);
            registration = repository.save(registration);
            return new RegistrationUpdateDTO(registration);
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
    
}
