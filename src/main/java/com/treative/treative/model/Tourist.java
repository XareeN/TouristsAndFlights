package com.treative.treative.model;

import lombok.Generated;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Tourist {

    @Id
    private String id;
    private String name;
    private String surname;
    private String gender;
    private String country;
    private String notes;
    private String birthday;

    public Tourist() {
    }

    public Tourist(String name, String surname, String gender, String country, String notes, String birthday) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.country = country;
        this.notes = notes;
        this.birthday = birthday;
    }

    public Tourist(String id, String name, String surname, String gender, String country, String notes, String birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.country = country;
        this.notes = notes;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
