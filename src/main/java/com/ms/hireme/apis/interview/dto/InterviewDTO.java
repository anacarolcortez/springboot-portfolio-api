package com.ms.hireme.apis.interview.dto;

import java.time.Instant;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ms.hireme.apis.interview.model.Interview;
import com.ms.hireme.apis.registration.dto.RegInterviewDTO;
import com.ms.hireme.apis.registration.model.Registration;


public class InterviewDTO {

    private UUID id;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Appointment cannot be null")
    private Instant appointment;

    @NotNull(message = "Interviewer id cannot be null")
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

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getAppointment() {
        return appointment;
    }

    public void setAppointment(Instant appointment) {
        this.appointment = appointment;
    }

    public RegInterviewDTO getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(RegInterviewDTO interviewer) {
        this.interviewer = interviewer;
    }
    
    
}
