package com.ms.hireme.resume.dto;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.hireme.resume.model.Degree;
import com.ms.hireme.resume.model.Education;

public class EducationDTO {

    @JsonIgnore
    private UUID id;

    private String title;
    private Date startDate;
    private Date endDate;
    private Degree degree;
    private String country;
    private String institution;

    @JsonIgnore
    private CandidateDTO candidate;

    public EducationDTO() {
    }

    public EducationDTO(UUID id, String title, Date startDate, Date endDate, Degree degree, String country,
            String institution) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.degree = degree;
        this.country = country;
        this.institution = institution;
    }

    public EducationDTO(Education education) {
        this.id = education.getId();
        this.title = education.getTitle();
        this.startDate = education.getStartDate();
        this.endDate = education.getEndDate();
        this.degree = education.getDegree();
        this.country = education.getCountry();
        this.institution = education.getInstitution();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Degree getDegree() {
        return degree;
    }

    public String getCountry() {
        return country;
    }

    public String getInstitution() {
        return institution;
    }

    public CandidateDTO getCandidate() {
        return candidate;
    }

    

}
