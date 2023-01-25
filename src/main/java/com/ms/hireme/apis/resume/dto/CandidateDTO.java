package com.ms.hireme.apis.resume.dto;

import java.io.Serializable;
import java.util.UUID;

import com.ms.hireme.apis.resume.model.Candidate;

public class CandidateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private String aboutme;
    private String phone;
    private String email;
    private String linkedin;
    private String github;
    private String country;
    private String state;
    private String city;

    public CandidateDTO(UUID id, String name, String aboutme, String phone, String email, String linkedin,
            String github, String country, String state, String city) {
        this.id = id;
        this.name = name;
        this.aboutme = aboutme;
        this.phone = phone;
        this.email = email;
        this.linkedin = linkedin;
        this.github = github;
        this.country = country;
        this.state = state;
        this.city = city;
    }

    public CandidateDTO(Candidate candidate) {
        this.id = candidate.getId();
        this.name = candidate.getName();
        this.aboutme = candidate.getAboutme();
        this.phone = candidate.getPhone();
        this.email = candidate.getEmail();
        this.linkedin = candidate.getLinkedin();
        this.github = candidate.getGithub();
        this.country = candidate.getCountry();
        this.state = candidate.getState();
        this.city = candidate.getCity();
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

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
