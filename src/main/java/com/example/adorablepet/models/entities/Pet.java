package com.example.adorablepet.models.entities;

import com.example.adorablepet.models.enums.Chipped;
import com.example.adorablepet.models.enums.TypeOfAnimal;
import jakarta.persistence.*;

import java.math.BigDecimal;

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
}
