package com.ms.hireme.apis.registration.dto;

import java.util.UUID;

import com.ms.hireme.apis.registration.model.Registration;

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

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCompany() {
        return company;
    }
   
    
}
