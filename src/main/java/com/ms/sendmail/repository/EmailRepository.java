package com.ms.sendmail.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.sendmail.model.Email;

public interface EmailRepository extends JpaRepository<Email, UUID> {
    
}
