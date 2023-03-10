package com.ms.hireme.apis.registration.dto;

import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.hireme.apis.registration.model.Registration;

public class RegistrationCreateDTO {

    @JsonIgnore
    private UUID id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "E-mail must be valid")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotBlank(message = "Job title cannot be blank")
    private String jobTitle;

    @NotBlank(message = "Company name cannot be blank")
    private String company;

    public RegistrationCreateDTO(){}

    public RegistrationCreateDTO(UUID id, String name, String email, String password, String jobTitle, String company) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.jobTitle = jobTitle;
        this.company = company;
    }

    public RegistrationCreateDTO(Registration registration) {
        this.id = registration.getId();
        this.name = registration.getName();
        this.email = registration.getEmail();
        this.password = registration.getPassword();
        this.jobTitle = registration.getJobTitle();
        this.company = registration.getCompany();
    }

    public void convertDtoToEntity(RegistrationCreateDTO dto, Registration entity){
        entity.setEmail(dto.getEmail());
        entity.setCompany(dto.getCompany());
        entity.setJobTitle(dto.getJobTitle());
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
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
