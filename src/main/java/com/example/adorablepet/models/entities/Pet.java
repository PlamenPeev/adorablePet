package com.example.adorablepet.models.entities;

import com.example.adorablepet.models.enums.Chipped;
import com.example.adorablepet.models.enums.TypeOfAnimal;
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
    private Chipped chip;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeOfAnimal type;

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

    public Chipped getChip() {
        return chip;
    }

    public Pet setChip(Chipped chip) {
        this.chip = chip;
        return this;
    }

    public TypeOfAnimal getType() {
        return type;
    }

    public Pet setType(TypeOfAnimal type) {
        this.type = type;
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
