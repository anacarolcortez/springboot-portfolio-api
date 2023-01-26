package com.ms.hireme.apis.interview.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.hireme.apis.interview.dto.InterviewCreateDTO;
import com.ms.hireme.apis.interview.dto.InterviewDTO;
import com.ms.hireme.apis.interview.dto.InterviewUpdateDTO;
import com.ms.hireme.apis.interview.model.Interview;
import com.ms.hireme.apis.interview.repository.InterviewRepository;
import com.ms.hireme.apis.registration.model.Registration;
import com.ms.hireme.apis.registration.repository.RegistrationRepository;
import com.ms.hireme.utils.exceptions.DataBaseException;
import com.ms.hireme.utils.exceptions.ResourceNotFoundException;

@Service
public class InterviewService {
    
    @Autowired
    private InterviewRepository repository;

    @Autowired
    private RegistrationRepository regRepository;

    //todas as entrevistas do entrevistador logado
    @Transactional(readOnly = true)
    public List<InterviewDTO> getAllByInterviewerId(UUID id){
        List<Interview> interviews = repository.findByInterviewerId(id);
        return interviews.stream().map(i -> new InterviewDTO(i, i.getInterviewer())).collect(Collectors.toList());
    }

    //retorna uma entrevista pelo id
    @Transactional(readOnly = true)
    public InterviewDTO getInterviewById(UUID id){
        Optional<Interview> obj = repository.findById(id);
        Interview interview = obj.orElseThrow(() -> new ResourceNotFoundException("Interview id not found: " + id));
        return new InterviewDTO(interview, interview.getInterviewer());
    }

    @Transactional
    public InterviewCreateDTO createInterview(UUID id, InterviewCreateDTO interviewDTO){
        Interview interview = new Interview();
        Registration interviewer = regRepository.getReferenceById(id);
        interviewDTO.convertDtoToEntity(interviewDTO, interview, interviewer);
        interview = repository.save(interview);
        return new InterviewCreateDTO(interview, interview.getInterviewer());
    }

    @Transactional
    public InterviewUpdateDTO updateInterview(UUID id, InterviewUpdateDTO interviewDTO){
        try {
            Interview interview = repository.getReferenceById(id);
            interviewDTO.convertDtoToEntity(interviewDTO, interview);
            interview = repository.save(interview);
            return new InterviewUpdateDTO(interview, interview.getInterviewer());
        } catch (EntityNotFoundException err){
            throw new ResourceNotFoundException("Id not found" + id);
        }
    }

    public void delete(UUID id){
        try{
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException err){
            throw new ResourceNotFoundException("Id not found" + id);
        } catch (DataIntegrityViolationException err) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
