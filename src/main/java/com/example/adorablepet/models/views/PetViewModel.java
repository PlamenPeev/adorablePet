package com.example.adorablepet.models.views;

import com.example.adorablepet.models.entities.Pet;
import com.example.adorablepet.models.entities.TypeOfHelp;
import com.example.adorablepet.models.entities.UserEntity;
import com.example.adorablepet.models.enums.ChippedEnumName;
import com.example.adorablepet.models.enums.TypeOfAnimalEnumName;
import jakarta.persistence.*;

import java.time.LocalDate;

public class PetViewModel {

    private Long id;
    private String name;
    private Double age;
    private ChippedEnumName chippedEnumName;
    private TypeOfAnimalEnumName typeOfAnimalEnumName;
    private TypeOfHelp typeOfHelp;
    private UserEntity owner;
    private LocalDate dateOfVisit;
    private int hourOfVisit;

    public PetViewModel(Pet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.age = pet.getAge();
        this.chippedEnumName = pet.getChippedEnumName();
        this.typeOfAnimalEnumName = pet.getTypeOfAnimalEnumName();
        this.typeOfHelp = pet.getTypeOfHelp();
        this.owner = pet.getOwner();
        this.dateOfVisit = pet.getDateOfVisit();
        this.hourOfVisit = pet.getHourOfVisit();
    }

    public PetViewModel() {
    }

    public Long getId() {
        return id;
    }

    public PetViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PetViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Double getAge() {
        return age;
    }

    public PetViewModel setAge(Double age) {
        this.age = age;
        return this;
    }

    public ChippedEnumName getChippedEnumName() {
        return chippedEnumName;
    }

    public PetViewModel setChippedEnumName(ChippedEnumName chippedEnumName) {
        this.chippedEnumName = chippedEnumName;
        return this;
    }

    public TypeOfAnimalEnumName getTypeOfAnimalEnumName() {
        return typeOfAnimalEnumName;
    }

    public PetViewModel setTypeOfAnimalEnumName(TypeOfAnimalEnumName typeOfAnimalEnumName) {
        this.typeOfAnimalEnumName = typeOfAnimalEnumName;
        return this;
    }

    public TypeOfHelp getTypeOfHelp() {
        return typeOfHelp;
    }

    public PetViewModel setTypeOfHelp(TypeOfHelp typeOfHelp) {
        this.typeOfHelp = typeOfHelp;
        return this;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public PetViewModel setOwner(UserEntity owner) {
        this.owner = owner;
        return this;
    }

    public LocalDate getDateOfVisit() {
        return dateOfVisit;
    }

    public PetViewModel setDateOfVisit(LocalDate dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
        return this;
    }

    public int getHourOfVisit() {
        return hourOfVisit;
    }

    public PetViewModel setHourOfVisit(int hourOfVisit) {
        this.hourOfVisit = hourOfVisit;
        return this;
    }
}
