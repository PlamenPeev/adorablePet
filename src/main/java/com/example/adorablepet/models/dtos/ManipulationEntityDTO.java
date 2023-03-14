package com.example.adorablepet.models.dtos;

public class ManipulationEntityDTO {

    private String name;

    public ManipulationEntityDTO() {
    }

    public String getName() {
        return name;
    }

    public ManipulationEntityDTO setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "ManipulationEntityDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
