package com.ms.hireme.apis.resume.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.hireme.apis.resume.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, UUID> {
    
}
