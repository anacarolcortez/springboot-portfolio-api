package com.ms.hireme.resume.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.hireme.resume.dto.EducationDTO;
import com.ms.hireme.resume.model.Education;
import com.ms.hireme.resume.repository.EducationRepository;


@Service
public class EducationService {

    @Autowired
    private EducationRepository repository;


    @Transactional(readOnly = true)
    public List<EducationDTO> getEducationByCandidateId(UUID id){
        List<Education> education = repository.findByCandidateId(id);
        return education.stream().map(e -> new EducationDTO(e)).collect(Collectors.toList());
    }
    
}
