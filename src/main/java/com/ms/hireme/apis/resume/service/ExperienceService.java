package com.ms.hireme.apis.resume.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.hireme.apis.resume.dto.ExperienceDTO;
import com.ms.hireme.apis.resume.model.Experience;
import com.ms.hireme.apis.resume.repository.ExperienceRepository;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository repository;

    @Transactional(readOnly = true)
    public List<ExperienceDTO> getExperienceByCandidateId(UUID id){
        List<Experience> experience = repository.findByCandidateId(id);
        return experience.stream().map(e -> new ExperienceDTO(e)).collect(Collectors.toList());
    }
    
}
