package com.example.adorablepet.models.dtos;

import com.example.adorablepet.models.enums.ChippedEnumName;
import com.example.adorablepet.models.enums.TypeOfAnimalEnumName;
import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public class PetAddDTO {

    @NotNull
    @Length(min=2,
            message = "Name length should be more than 2 characters.")
    private String name;

    @NotNull
    @Positive
    private Double age;

    @NotNull
    private ChippedEnumName chippedEnumName;

    @NotNull
    private TypeOfAnimalEnumName typeOfAnimalEnumName;

    @NotNull
    private TypeOfHelpEnumName typeOfHelp;

    @FutureOrPresent
    private LocalDate date;

    @NotNull( message = "The hour should be between 09:00 and 17:00.")
    @Min(9)
    @Max(17)
    private int hourOfVisit;


    public PetAddDTO() {
    }

    public String getName() {
        return name;
    }

    public PetAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Double getAge() {
        return age;
    }

    public PetAddDTO setAge(Double age) {
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


    public LocalDate getDate() {
        return date;
    }

    public PetAddDTO setDate(LocalDate date) {
        this.date = date;
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
