package com.example.adorablepet.models.dtos;

import java.math.BigDecimal;

public class TypeOfManipulationDTO {

    private Long id;
    private String title;

    private BigDecimal price;
    private ManipulationEntityDTO type;

    public TypeOfManipulationDTO() {
    }

    public Long getId() {
        return id;
    }

    public TypeOfManipulationDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TypeOfManipulationDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TypeOfManipulationDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ManipulationEntityDTO getType() {
        return type;
    }

    public TypeOfManipulationDTO setType(ManipulationEntityDTO type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "TypeOfManipulationDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}
