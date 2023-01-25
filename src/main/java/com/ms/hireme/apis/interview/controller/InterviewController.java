package com.ms.hireme.apis.interview.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ms.hireme.apis.interview.dto.InterviewCreateDTO;
import com.ms.hireme.apis.interview.dto.InterviewDTO;
import com.ms.hireme.apis.interview.dto.InterviewUpdateDTO;
import com.ms.hireme.apis.interview.service.InterviewService;
import com.ms.hireme.apis.sendmail.dto.EmailDTO;

@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private InterviewService service;

    @Autowired
    private RabbitTemplate rbt;

    @Value("${spring.rabbitmq.queue}")
    private String routingkey;

    @GetMapping("/{id}")
    public ResponseEntity<InterviewDTO> getInterviewById(@PathVariable UUID id){
        InterviewDTO interview = service.getInterviewById(id);
        return ResponseEntity.ok().body(interview);
    }

    @GetMapping("/interviewer/{id}")
    public ResponseEntity<List<InterviewDTO>> getAllByInterviewerId(@PathVariable UUID id){
        List<InterviewDTO> interviews = service.getAllByInterviewerId(id);
        return ResponseEntity.ok().body(interviews);
    }
    
    @PostMapping
    public ResponseEntity<InterviewCreateDTO> createInterview(@Valid @RequestBody InterviewCreateDTO interviewDTO){
        InterviewCreateDTO interview = service.createInterview(interviewDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(interview.getId())
                .toUri();
        EmailDTO email = new EmailDTO(interview);
        rbt.convertAndSend(routingkey, email);
        return ResponseEntity.created(uri).body(interview);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<InterviewUpdateDTO> updateInterviewById(@PathVariable UUID id, @RequestBody InterviewUpdateDTO interviewDTO){
        InterviewUpdateDTO interview = service.updateInterview(id, interviewDTO);
        return ResponseEntity.ok().body(interview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterviewById(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
