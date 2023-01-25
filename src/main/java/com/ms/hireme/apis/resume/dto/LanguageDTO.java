package com.ms.hireme.apis.resume.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.hireme.apis.resume.model.Language;
import com.ms.hireme.apis.resume.model.Proficiency;

public class LanguageDTO {

    @JsonIgnore
    private UUID id;

    private String language;
    private Proficiency wittingProficiency;
    private Proficiency readingProficiency;
    private Proficiency speakingProficiency;

    @JsonIgnore
    private CandidateDTO candidate;

    public LanguageDTO() {
    }

    public LanguageDTO(UUID id, String language, Proficiency wittingProficiency, Proficiency readingProficiency,
            Proficiency speakingProficiency) {
        this.id = id;
        this.language = language;
        this.wittingProficiency = wittingProficiency;
        this.readingProficiency = readingProficiency;
        this.speakingProficiency = speakingProficiency;
    }

    public LanguageDTO(Language language) {
        this.id = language.getId();
        this.language = language.getLanguage();
        this.wittingProficiency = language.getWittingProficiency();
        this.readingProficiency = language.getReadingProficiency();
        this.speakingProficiency = language.getSpeakingProficiency();
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

    public CandidateDTO getCandidate() {
        return candidate;
    }

    

}
