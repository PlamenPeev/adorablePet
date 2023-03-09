package com.example.adorablepet.models.service;

import com.example.adorablepet.models.entities.TypeOfHelp;
import com.example.adorablepet.models.entities.UserEntity;
import com.example.adorablepet.models.enums.ChippedEnumName;
import com.example.adorablepet.models.enums.TypeOfAnimalEnumName;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class PetServiceModel {

    private Long id;
    private String name;
    private BigDecimal age;
    private ChippedEnumName chippedEnumName;
    private TypeOfAnimalEnumName typeOfAnimalEnumName;
    private TypeOfHelp typeOfHelp;
    private UserEntity owner;
    private Set<UserEntity> adopters;
    private LocalDate dateOfVisit;
    private int hourOfVisit;

    public PetServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public PetServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PetServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getAge() {
        return age;
    }

    public PetServiceModel setAge(BigDecimal age) {
        this.age = age;
        return this;
    }

    public ChippedEnumName getChippedEnumName() {
        return chippedEnumName;
    }

    public PetServiceModel setChippedEnumName(ChippedEnumName chippedEnumName) {
        this.chippedEnumName = chippedEnumName;
        return this;
    }

    public TypeOfAnimalEnumName getTypeOfAnimalEnumName() {
        return typeOfAnimalEnumName;
    }

    public PetServiceModel setTypeOfAnimalEnumName(TypeOfAnimalEnumName typeOfAnimalEnumName) {
        this.typeOfAnimalEnumName = typeOfAnimalEnumName;
        return this;
    }

    public TypeOfHelp getTypeOfHelp() {
        return typeOfHelp;
    }

    public PetServiceModel setTypeOfHelp(TypeOfHelp typeOfHelp) {
        this.typeOfHelp = typeOfHelp;
        return this;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public PetServiceModel setOwner(UserEntity owner) {
        this.owner = owner;
        return this;
    }

    public Set<UserEntity> getAdopters() {
        return adopters;
    }

    public PetServiceModel setAdopters(Set<UserEntity> adopters) {
        this.adopters = adopters;
        return this;
    }

    public LocalDate getDateOfVisit() {
        return dateOfVisit;
    }

    public PetServiceModel setDateOfVisit(LocalDate dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
        return this;
    }

    public int getHourOfVisit() {
        return hourOfVisit;
    }

    public PetServiceModel setHourOfVisit(int hourOfVisit) {
        this.hourOfVisit = hourOfVisit;
        return this;
    }
}
