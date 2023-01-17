package com.ms.hireme.resume.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false)
    private String aboutme;

    @Column(nullable = false, length = 15)
    private String phone;

    @Column(nullable = false, length = 80)
    private String email;

    @Column(nullable = false)
    private String linkedin;

    @Column(nullable = false)
    private String github;

    @Column(nullable = false, length = 50)
    private String country;

    @Column(nullable = false, length = 2)
    private String state;

    @Column(nullable = false, length = 80)
    private String city;

    public Candidate() {
    };


    public Candidate(UUID id, String name, String aboutme, String phone, String email, String linkedin, String github,
            String country, String state, String city) {
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


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAboutme() {
        return aboutme;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getGithub() {
        return github;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
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
        Candidate other = (Candidate) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
