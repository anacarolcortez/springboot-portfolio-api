package com.ms.hireme.resume.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.hireme.resume.dto.CourseDTO;
import com.ms.hireme.resume.model.Course;
import com.ms.hireme.resume.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    @Transactional(readOnly = true)
    public List<CourseDTO> getCourseByCandidateId(UUID id){
        List<Course> courses = repository.findByCandidateId(id);
        List<CourseDTO> coursesDTO = courses.stream().map(c -> new CourseDTO(c)).collect(Collectors.toList());
        return coursesDTO;
    }
}
