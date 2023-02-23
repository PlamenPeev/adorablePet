package com.example.adorablepet.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{

    @Column(name ="date_of_visit")
    private LocalDate dateOfVisit;

    @Column(name ="hour_of_visit")
    private String hourOfVisit;

    @ManyToOne
    private Pet pet;

    public Visit() {
    }

    public LocalDate getDateOfVisit() {
        return dateOfVisit;
    }

    public Visit setDateOfVisit(LocalDate dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
        return this;
    }

    public String getHourOfVisit() {
        return hourOfVisit;
    }

    public Visit setHourOfVisit(String hourOfVisit) {
        this.hourOfVisit = hourOfVisit;
        return this;
    }

    public Pet getPet() {
        return pet;
    }

    public Visit setPet(Pet pet) {
        this.pet = pet;
        return this;
    }
}
