package com.ms.hireme.registration.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.hireme.interview.dto.InterviewDTO;
import com.ms.hireme.registration.model.Registration;

public class RegInterviewDTO {

    // @JsonIgnore
    private UUID id;

    private String name;
    private String email;
    private String jobTitle;
    private String company;
    
    @JsonIgnore
    private InterviewDTO interviewer;

    public RegInterviewDTO(){}


    public RegInterviewDTO(UUID id, String name, String email, String jobTitle, String company) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.company = company;
    }

    public RegInterviewDTO(Registration registration) {
        this.id = registration.getId();
        this.name = registration.getName();
        this.email = registration.getEmail();
        this.jobTitle = registration.getJobTitle();
        this.company = registration.getCompany();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public InterviewDTO getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(InterviewDTO interviewer) {
        this.interviewer = interviewer;
    }

    
}
