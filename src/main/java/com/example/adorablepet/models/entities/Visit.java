package com.example.adorablepet.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{

    @Column(name ="date_of_visit")
    private LocalDate dateOfVisit;

    @Column(name ="hour_of_visit")
    private String hourOfVisit;
}
