package com.ms.hireme.registration.dto;

import java.util.UUID;

import com.ms.hireme.registration.model.Registration;

public class RegistrationDTO {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private String jobTitle;
    private String company;

    public RegistrationDTO(){}

    public RegistrationDTO(UUID id, String name, String email, String password, String jobTitle, String company) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.jobTitle = jobTitle;
        this.company = company;
    }

    public RegistrationDTO(Registration registration) {
        this.id = registration.getId();
        this.name = registration.getName();
        this.email = registration.getEmail();
        this.password = registration.getPassword();
        this.jobTitle = registration.getJobTitle();
        this.company = registration.getCompany();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    
    
}