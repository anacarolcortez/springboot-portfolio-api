package com.ms.hireme.resume.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// @Entity
// @Table(name="tb_resume")
public class Resume {

    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // private UUID id;

    // @OneToOne
    // private Candidate candidate;

    // private List<Experience> experiences;
    // private List<Education> education;
    // private List<Course> courses;
    // private List<Language> languages;

    public Resume(){}
}
