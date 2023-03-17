package com.example.adorablepet.models.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "manipulation_types")
public class TypeOfManipulation extends BaseEntity{

    private String title;

    private BigDecimal price;

    @ManyToOne
    private ManipulationEntity manipulation;

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

    public ManipulationEntity getManipulation() {
        return manipulation;
    }

    public TypeOfManipulation setManipulation(ManipulationEntity manipulation) {
        this.manipulation = manipulation;
        return this;
    }

    @Override
    public String toString() {
        return "TypeOfManipulation{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", manipulation=" + (manipulation != null ? manipulation.getName() : null) +
                '}';
    }
}
