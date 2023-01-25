package com.ms.hireme.apis.resume.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tb_language")
public class Language {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 80)
    private String language;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Proficiency wittingProficiency;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Proficiency readingProficiency;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Proficiency speakingProficiency;

    @ManyToOne
    private Candidate candidate;

    public Language(){}

    public Language(UUID id, String language, Proficiency wittingProficiency, Proficiency readingProficiency,
            Proficiency speakingProficiency) {
        this.id = id;
        this.language = language;
        this.wittingProficiency = wittingProficiency;
        this.readingProficiency = readingProficiency;
        this.speakingProficiency = speakingProficiency;
    }

    public UUID getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public Proficiency getWittingProficiency() {
        return wittingProficiency;
    }

    public Proficiency getReadingProficiency() {
        return readingProficiency;
    }

    public Proficiency getSpeakingProficiency() {
        return speakingProficiency;
    }

    public Candidate getCandidate() {
        return candidate;
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
        Language other = (Language) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }  
    
}
