package com.example.adorablepet.models.entities;

import com.example.adorablepet.models.enums.ChippedEnumName;
import com.example.adorablepet.models.enums.TypeOfAnimalEnumName;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

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
    private User owner;

    @ManyToMany
    private Set<User> adopters;

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

    public User getOwner() {
        return owner;
    }

    public Pet setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public Set<User> getAdopters() {
        return adopters;
    }

    public Pet setAdopters(Set<User> adopters) {
        this.adopters = adopters;
        return this;
    }
}
