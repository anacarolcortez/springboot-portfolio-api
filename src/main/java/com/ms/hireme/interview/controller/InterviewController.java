package com.ms.hireme.interview.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.hireme.interview.dto.InterviewDTO;
import com.ms.hireme.interview.service.InterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private InterviewService service;

    @GetMapping("/{id}")
    public ResponseEntity<InterviewDTO> getAllById(@PathVariable UUID id){
        InterviewDTO interview = service.getInterviewById(id);
        return ResponseEntity.ok().body(interview);
    }

    @GetMapping("/interviewer/{id}")
    public ResponseEntity<List<InterviewDTO>> getAllByInterviewerId(@PathVariable UUID id){
        List<InterviewDTO> interviews = service.getAllByInterviewerId(id);
        return ResponseEntity.ok().body(interviews);
    }


    
}
