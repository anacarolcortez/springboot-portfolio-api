package com.ms.hireme.resume.dto;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.hireme.resume.model.Experience;
import com.ms.hireme.resume.model.Level;

public class ExperienceDTO {

    private UUID id;
    private String company;
    private String jobTitle;
    private Level level;
    private Date startDate;
    private Date endDate;
    private String description;
    private String country;

    @JsonIgnore
    private CandidateDTO candidate;

    public ExperienceDTO() {
    }

    public ExperienceDTO(UUID id, String company, String jobTitle, Level level, Date startDate, Date endDate,
            String description, String country) {
        this.id = id;
        this.company = company;
        this.jobTitle = jobTitle;
        this.level = level;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.country = country;
    }

    public ExperienceDTO(Experience experience) {
        this.id = experience.getId();
        this.company = experience.getCompany();
        this.jobTitle = experience.getJobTitle();
        this.level = experience.getLevel();
        this.startDate = experience.getStartDate();
        this.endDate = experience.getEndDate();
        this.description = experience.getDescription();
        this.country = experience.getCountry();
    }

    public UUID getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Level getLevel() {
        return level;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public String getCountry() {
        return country;
    }

    public CandidateDTO getCandidate() {
        return candidate;
    }

    
}
