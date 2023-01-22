package com.ms.hireme.interview.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.hireme.interview.dto.InterviewDTO;
import com.ms.hireme.interview.model.Interview;
import com.ms.hireme.interview.repository.InterviewRepository;
import com.ms.hireme.utils.exceptions.ResourceNotFoundException;

@Service
public class InterviewService {
    
    @Autowired
    private InterviewRepository repository;

    //get de todas as entrevistas de um entrevistador
    @Transactional(readOnly = true)
    public List<InterviewDTO> getAllByInterviewerId(UUID id){
        List<Interview> interviews = repository.findByInterviewerId(id);
        return interviews.stream().map(i -> new InterviewDTO(i)).collect(Collectors.toList());
    }

    //get entrevista pelo id
    @Transactional(readOnly = true)
    public InterviewDTO getInterviewById(UUID id){
        Optional<Interview> obj = repository.findById(id);
        Interview interview = obj.orElseThrow(() -> new ResourceNotFoundException("Interview id not found: " + id));
        return new InterviewDTO(interview, interview.getInterviewer());
    }
}
