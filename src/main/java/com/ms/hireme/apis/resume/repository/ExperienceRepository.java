package com.ms.hireme.apis.resume.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.hireme.apis.resume.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, UUID>{
    
    List<Experience> findByCandidateId(UUID id);
}
