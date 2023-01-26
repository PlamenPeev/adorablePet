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
}
