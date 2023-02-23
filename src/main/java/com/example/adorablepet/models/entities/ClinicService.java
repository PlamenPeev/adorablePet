package com.example.adorablepet.models.entities;

import com.example.adorablepet.models.enums.TypeOfHelp;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "clinic_services")
public class ClinicService extends BaseEntity{

    @Column
    @Enumerated(EnumType.STRING)
    private TypeOfHelp typeOfHelp;

    @Column
    private BigDecimal price;

    @ManyToOne
    private Pet pet;

    public ClinicService() {
    }

    public TypeOfHelp getTypeOfHelp() {
        return typeOfHelp;
    }

    public ClinicService setTypeOfHelp(TypeOfHelp typeOfHelp) {
        this.typeOfHelp = typeOfHelp;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ClinicService setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Pet getPet() {
        return pet;
    }

    public ClinicService setPet(Pet pet) {
        this.pet = pet;
        return this;
    }
}
