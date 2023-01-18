package com.ms.hireme.resume.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//This is a portfolio API, therefore there will be only ONE resume available, the developer's'.

@Entity
@Table(name="tb_resume")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private Candidate candidate;

    @OneToMany
    private List<Experience> experiences;

    @OneToMany
    private List<Education> education;

    @OneToMany
    private List<Course> courses;

    @OneToMany
    private List<Language> languages;

    public Resume(){}

    public Resume(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public List<Education> getEducation() {
        return education;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Resume other = (Resume) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
