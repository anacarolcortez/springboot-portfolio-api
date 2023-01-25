package com.ms.hireme.apis.sendmail.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.hireme.apis.sendmail.model.Email;

public interface EmailRepository extends JpaRepository<Email, UUID> {
    
}
