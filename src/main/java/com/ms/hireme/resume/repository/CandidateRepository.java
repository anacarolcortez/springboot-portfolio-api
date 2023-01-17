package com.ms.hireme.resume.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.hireme.resume.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, UUID> {
    
}