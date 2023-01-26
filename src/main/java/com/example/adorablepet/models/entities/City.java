package com.example.adorablepet.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cities")
public class City extends BaseEntity{

    @Column
    private String name;

    @Column
    private String address;
}
