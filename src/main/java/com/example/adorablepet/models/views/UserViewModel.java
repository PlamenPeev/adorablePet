package com.example.adorablepet.models.views;

public class UserViewModel {

    private String email;
    private Integer countOfPets;

    public UserViewModel() {
    }

    public String getEmail() {
        return email;
    }

    public UserViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getCountOfPets() {
        return countOfPets;
    }

    public UserViewModel setCountOfPets(Integer countOfPets) {
        this.countOfPets = countOfPets;
        return this;
    }
}
