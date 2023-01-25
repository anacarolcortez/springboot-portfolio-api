package com.ms.hireme.apis.registration.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.hireme.apis.registration.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, UUID> {
    
}
