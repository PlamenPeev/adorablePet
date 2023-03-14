package com.example.adorablepet.models.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "types")
public class TypeOfManipulation extends BaseEntity{

    private String title;

    private BigDecimal price;

    @ManyToOne
    private ManipulationEntity type;

    public TypeOfManipulation() {
    }

    public String getTitle() {
        return title;
    }

    public TypeOfManipulation setTitle(String title) {
        this.title = title;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TypeOfManipulation setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ManipulationEntity getType() {
        return type;
    }

    public TypeOfManipulation setType(ManipulationEntity type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "TypeOfManipulation{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", type=" + (type != null ? type.getName() : null) +
                '}';
    }
}
