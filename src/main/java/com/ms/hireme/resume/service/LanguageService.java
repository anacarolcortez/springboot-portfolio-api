package com.ms.hireme.resume.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.hireme.resume.dto.LanguageDTO;
import com.ms.hireme.resume.model.Language;
import com.ms.hireme.resume.repository.LanguageRepository;

@Service
public class LanguageService {
    
    @Autowired
    private LanguageRepository repository;

    @Transactional(readOnly = true)
    public List<LanguageDTO> getLanguageByCandaidateId(UUID id){
        List<Language> languages = repository.findByCandidateId(id);
        return languages.stream().map(l -> new LanguageDTO(l)).collect(Collectors.toList());
    }
}
