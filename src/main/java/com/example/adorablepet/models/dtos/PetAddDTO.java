package com.example.adorablepet.models.dtos;

import com.example.adorablepet.models.entities.TypeOfHelp;
import com.example.adorablepet.models.entities.UserEntity;
import com.example.adorablepet.models.enums.ChippedEnumName;
import com.example.adorablepet.models.enums.TypeOfAnimalEnumName;
import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class PetAddDTO {

    @NotNull
    @Length(min=2,
            message = "Name length should be more than 2 characters.")
    private String name;

    @NotNull
    @Positive
    private BigDecimal age;

    @NotNull
    private ChippedEnumName chippedEnumName;

    @NotNull
    private TypeOfAnimalEnumName typeOfAnimalEnumName;

    @NotNull
    private TypeOfHelpEnumName typeOfHelp;

    @NotNull
    private UserEntity owner;

    @NotNull
    @FutureOrPresent
    private LocalDate dateOfVisit;

    @NotNull( message = "The hour should be between 09:00 and 17:00.")
    @Min(9)
    @Max(17)
    private int hourOfVisit;


    private Set<UserEntity> adopters;

    public PetAddDTO() {
    }

    public String getName() {
        return name;
    }

    public PetAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getAge() {
        return age;
    }

    public PetAddDTO setAge(BigDecimal age) {
        this.age = age;
        return this;
    }

    public ChippedEnumName getChippedEnumName() {
        return chippedEnumName;
    }

    public PetAddDTO setChippedEnumName(ChippedEnumName chippedEnumName) {
        this.chippedEnumName = chippedEnumName;
        return this;
    }

    public TypeOfAnimalEnumName getTypeOfAnimalEnumName() {
        return typeOfAnimalEnumName;
    }

    public PetAddDTO setTypeOfAnimalEnumName(TypeOfAnimalEnumName typeOfAnimalEnumName) {
        this.typeOfAnimalEnumName = typeOfAnimalEnumName;
        return this;
    }

    public TypeOfHelpEnumName getTypeOfHelp() {
        return typeOfHelp;
    }

    public PetAddDTO setTypeOfHelp(TypeOfHelpEnumName typeOfHelp) {
        this.typeOfHelp = typeOfHelp;
        return this;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public PetAddDTO setOwner(UserEntity owner) {
        this.owner = owner;
        return this;
    }

    public Set<UserEntity> getAdopters() {
        return adopters;
    }

    public PetAddDTO setAdopters(Set<UserEntity> adopters) {
        this.adopters = adopters;
        return this;
    }

    public LocalDate getDateOfVisit() {
        return dateOfVisit;
    }

    public PetAddDTO setDateOfVisit(LocalDate dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
        return this;
    }

    public int getHourOfVisit() {
        return hourOfVisit;
    }

    public PetAddDTO setHourOfVisit(int hourOfVisit) {
        this.hourOfVisit = hourOfVisit;
        return this;
    }
}
