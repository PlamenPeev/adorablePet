package com.example.adorablepet.models.entities;

import com.example.adorablepet.models.enums.ChippedEnumName;
import com.example.adorablepet.models.enums.TypeOfAnimalEnumName;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{

    @Column
    private String name;

    @Column
    private BigDecimal age;

    @Column
    @Enumerated(EnumType.STRING)
    private ChippedEnumName chippedEnumName;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeOfAnimalEnumName typeOfAnimalEnumName;

    @OneToOne
    private TypeOfHelp typeOfHelp;

    @ManyToOne
    private UserEntity owner;


    @Column(name ="date_of_visit")
    private LocalDate dateOfVisit;

    @Column(name ="hour_of_visit")
    private int hourOfVisit;

    public Pet() {
    }

    public String getName() {
        return name;
    }

    public Pet setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getAge() {
        return age;
    }

    public Pet setAge(BigDecimal age) {
        this.age = age;
        return this;
    }

    public ChippedEnumName getChippedEnumName() {
        return chippedEnumName;
    }

    public Pet setChippedEnumName(ChippedEnumName chippedEnumName) {
        this.chippedEnumName = chippedEnumName;
        return this;
    }

    public TypeOfAnimalEnumName getTypeOfAnimalEnumName() {
        return typeOfAnimalEnumName;
    }

    public Pet setTypeOfAnimalEnumName(TypeOfAnimalEnumName typeOfAnimalEnumName) {
        this.typeOfAnimalEnumName = typeOfAnimalEnumName;
        return this;
    }

    public TypeOfHelp getTypeOfHelp() {
        return typeOfHelp;
    }

    public Pet setTypeOfHelp(TypeOfHelp typeOfHelp) {
        this.typeOfHelp = typeOfHelp;
        return this;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public Pet setOwner(UserEntity owner) {
        this.owner = owner;
        return this;
    }


    public LocalDate getDateOfVisit() {
        return dateOfVisit;
    }

    public Pet setDateOfVisit(LocalDate dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
        return this;
    }

    public int getHourOfVisit() {
        return hourOfVisit;
    }

    public Pet setHourOfVisit(int hourOfVisit) {
        this.hourOfVisit = hourOfVisit;
        return this;
    }
}
