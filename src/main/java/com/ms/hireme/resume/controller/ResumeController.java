package com.ms.hireme.resume.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.hireme.resume.dto.CandidateDTO;
import com.ms.hireme.resume.dto.CourseDTO;
import com.ms.hireme.resume.dto.EducationDTO;
import com.ms.hireme.resume.dto.ExperienceDTO;
import com.ms.hireme.resume.service.CandidateService;
import com.ms.hireme.resume.service.CourseService;
import com.ms.hireme.resume.service.EducationService;
import com.ms.hireme.resume.service.ExperienceService;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private CandidateService service;

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private EducationService educationService;

    @Autowired
    private CourseService courseService;


    // In order to make it a 'metalinguistic' portfolio, there's only one candidate allowed in the list from DB: me ;)
    @GetMapping("/candidates")
    public ResponseEntity<List<CandidateDTO>> getTheOneCandidate(){
        List<CandidateDTO> candidates = service.getCandidates();
        return ResponseEntity.ok().body(candidates);
    }

    @GetMapping("/experiences/{id}")
    public ResponseEntity<List<ExperienceDTO>> getExperiencesByCandidateId(@PathVariable UUID id){
        List<ExperienceDTO> experiences = experienceService.getExperienceByCandidateId(id);
        return ResponseEntity.ok().body(experiences);
    }

    @GetMapping("/degrees/{id}")
    public ResponseEntity<List<EducationDTO>> getDegreesByCandidateId(@PathVariable UUID id){
        List<EducationDTO> degrees = educationService.getEducationByCandidateId(id);
        return ResponseEntity.ok().body(degrees);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<List<CourseDTO>> getCoursesByCandidateId(@PathVariable UUID id){
        List<CourseDTO> courses = courseService.getCourseByCandidateId(id);
        return ResponseEntity.ok().body(courses);
    }



    
}
