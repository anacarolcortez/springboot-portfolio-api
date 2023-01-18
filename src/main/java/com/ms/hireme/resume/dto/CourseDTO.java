package com.ms.hireme.resume.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.hireme.resume.model.Course;

public class CourseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String title;
    private Date startDate;
    private Date endDate;
    private String description;
    private String country;
    private String certificateUrl;

    @JsonIgnore
    private CandidateDTO candidate;

    public CourseDTO() {
    }

    public CourseDTO(UUID id, String title, Date startDate, Date endDate, String description, String country,
            String certificateUrl) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.country = country;
        this.certificateUrl = certificateUrl;
    }

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.title = course.getTitle();
        this.startDate = course.getStartDate();
        this.endDate = course.getEndDate();
        this.description = course.getDescription();
        this.country = course.getCountry();
        this.certificateUrl = course.getCertificateUrl();
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
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

    public String getDescription() {
        return description;
    }

    public String getCountry() {
        return country;
    }

    public String getCertificateUrl() {
        return certificateUrl;
    }

    public CandidateDTO getCandidate() {
        return candidate;
    }

}
