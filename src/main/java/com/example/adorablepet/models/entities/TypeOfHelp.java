package com.example.adorablepet.models.entities;

import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import jakarta.persistence.*;

@Entity
@Table(name="type_of_help")
public class TypeOfHelp extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private TypeOfHelpEnumName typeOfHelpEnumName;

    @Column(columnDefinition = "TEXT")
    private String description;

    public TypeOfHelp() {
    }

    public TypeOfHelpEnumName getTypeOfHelpEnumName() {
        return typeOfHelpEnumName;
    }

    public TypeOfHelp setTypeOfHelpEnumName(TypeOfHelpEnumName typeOfHelpEnumName) {
        this.typeOfHelpEnumName = typeOfHelpEnumName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TypeOfHelp setDescription(String description) {
        this.description = description;
        return this;
    }
}
