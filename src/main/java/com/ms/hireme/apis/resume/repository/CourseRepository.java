package com.ms.hireme.apis.resume.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.hireme.apis.resume.model.Course;

public interface CourseRepository extends JpaRepository<Course, UUID> {

    List<Course> findByCandidateId(UUID id);
    
}
