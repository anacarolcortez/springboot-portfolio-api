package com.ms.hireme.interview.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.hireme.interview.model.Interview;

public interface InterviewRepository extends JpaRepository<Interview, UUID> {

    List<Interview> findByInterviewerId(UUID id);
    
}
