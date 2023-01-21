package com.ms.hireme.registration.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.hireme.registration.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, UUID> {
    
}
