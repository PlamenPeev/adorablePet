package com.example.adorablepet.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity{

    @Column(name="country_name")
    private String countryName;

    @Column(name="city_name")
    private String cityName;

    @Column
    private String address;

    public Country() {
    }

    public String getCountryName() {
        return countryName;
    }

    public Country setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public Country setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Country setAddress(String address) {
        this.address = address;
        return this;
    }
}
