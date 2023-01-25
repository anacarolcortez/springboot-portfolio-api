package com.ms.hireme.apis.registration.dto;

import java.util.UUID;

import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.hireme.apis.registration.model.Registration;

public class RegistrationUpdateDTO {

    @JsonIgnore
    private UUID id;
    private String name;
    @Email(message = "E-mail must be valid")
    private String email;
    private String password;
    private String jobTitle;
    private String company;

    public RegistrationUpdateDTO(){}

    public RegistrationUpdateDTO(UUID id, String name, String email, String password, String jobTitle, String company) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.jobTitle = jobTitle;
        this.company = company;
    }

    public RegistrationUpdateDTO(Registration registration) {
        this.id = registration.getId();
        this.name = registration.getName();
        this.email = registration.getEmail();
        this.password = registration.getPassword();
        this.jobTitle = registration.getJobTitle();
        this.company = registration.getCompany();
    }

    public void convertDtoToEntity(RegistrationUpdateDTO dto, Registration entity){
        if(dto.getEmail() != null && !dto.getEmail().isBlank()){
            entity.setEmail(dto.getEmail());
        }
        
        if(dto.getCompany() != null && !dto.getCompany().isBlank()) {
            entity.setCompany(dto.getCompany());
        }
        
        if(dto.getJobTitle() != null && !dto.getJobTitle().isBlank()) {
            entity.setJobTitle(dto.getJobTitle());
        }

        if(dto.getName() != null && !dto.getName().isBlank()) {
            entity.setName(dto.getName());
        }

        if(dto.getPassword() != null && !dto.getPassword().isBlank()) {
            entity.setPassword(dto.getPassword());
        }

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
