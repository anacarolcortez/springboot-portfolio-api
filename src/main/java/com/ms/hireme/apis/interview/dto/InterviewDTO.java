package com.ms.hireme.apis.interview.dto;

import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.hireme.apis.interview.model.Interview;
import com.ms.hireme.apis.registration.dto.RegInterviewDTO;
import com.ms.hireme.apis.registration.model.Registration;


public class InterviewDTO {

    private UUID id;
    private String description;
    private Instant appointment;

    @JsonIgnore
    private RegInterviewDTO interviewer;

    public InterviewDTO() {}

    public InterviewDTO(UUID id, String description, Instant appointment) {
        this.id = id;
        this.description = description;
        this.appointment = appointment;
    }

    public InterviewDTO(Interview interview) {
        this.id = interview.getId();
        this.description = interview.getDescription();
        this.appointment = interview.getAppointment();
    }

    public InterviewDTO(Interview interview, Registration registration) {
        this(interview);
        this.interviewer = new RegInterviewDTO(registration);
    }


    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Instant getAppointment() {
        return appointment;
    }

    public RegInterviewDTO getInterviewer() {
        return interviewer;
    }
    
}
