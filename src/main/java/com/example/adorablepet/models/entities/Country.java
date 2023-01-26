package com.example.adorablepet.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity{

    @Column
    private String name;
}
