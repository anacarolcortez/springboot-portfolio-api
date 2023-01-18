package com.ms.hireme.resume.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.hireme.resume.model.Language;

public interface LanguageRepository extends JpaRepository<Language, UUID> {

    List<Language> findByCandidateId(UUID id);
    
}
