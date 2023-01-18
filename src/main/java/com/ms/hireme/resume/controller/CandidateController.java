package com.ms.hireme.resume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.hireme.resume.dto.CandidateDTO;
import com.ms.hireme.resume.service.CandidateService;

@RestController
@RequestMapping("/candidates/theone")
public class CandidateController {

    // In order to make it a 'metalinguistic' portfolio, there's only one candidate allowed in the DB: me ;)

    @Autowired
    private CandidateService service;

    @GetMapping
    public ResponseEntity<List<CandidateDTO>> getCandidates(){
        List<CandidateDTO> candidates = service.getCandidates();
        return ResponseEntity.ok().body(candidates);
    }
    
}
