package com.ms.hireme.registration.dto;

import com.ms.hireme.registration.model.Registration;

public class RegInterviewDTO {

    private String name;
    private String email;
    private String jobTitle;
    private String company;

    public RegInterviewDTO(){}

    public RegInterviewDTO(String name, String email, String jobTitle, String company) {
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.company = company;
    }

    public RegInterviewDTO(Registration registration) {
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

    
    
}
