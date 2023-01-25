package com.ms.hireme.apis.resume.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.hireme.apis.resume.model.Education;


public interface EducationRepository extends JpaRepository<Education, UUID> {

    List<Education> findByCandidateId(UUID id);
    
}
