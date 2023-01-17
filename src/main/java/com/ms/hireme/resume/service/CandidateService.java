package com.ms.hireme.resume.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.hireme.resume.dto.CandidateDTO;
import com.ms.hireme.resume.model.Candidate;
import com.ms.hireme.resume.repository.CandidateRepository;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository repository;


    @Transactional(readOnly = true)
    public List<CandidateDTO> getCandidates(){
        List<Candidate> candidate = repository.findAll();
        return candidate.stream().map(c -> new CandidateDTO(c)).collect(Collectors. toList());
    }
    
}
