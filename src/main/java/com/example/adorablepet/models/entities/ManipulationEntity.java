package com.example.adorablepet.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "manipulations")
public class ManipulationEntity extends BaseEntity{

    private String name;

    @OneToMany(mappedBy = "type")
    private List<TypeOfManipulation> types;

    public ManipulationEntity() {
    }

    public String getName() {
        return name;
    }



    public ManipulationEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<TypeOfManipulation> getTypes() {
        return types;
    }

    public ManipulationEntity setTypes(List<TypeOfManipulation> types) {
        this.types = types;
        return this;
    }
    @Override
    public String toString() {
        return "ManipulationEntity{" +
                "name='" + name + '\'' +
                ", types=" + types +
                '}';
    }

}
