package com.ms.hireme.resume.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.hireme.resume.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, UUID>{
    
    List<Experience> findByCandidateId(UUID id);
}
