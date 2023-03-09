package com.example.adorablepet.models.dtos;

import com.example.adorablepet.models.entities.Country;
import com.example.adorablepet.models.entities.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.ArrayList;
import java.util.List;

public class UserRegisterDTO {

//    @NotNull
//    @Length(min=3, max=20,
//            message = "Username should be between 3 and 20 characters.")
//        private String username;

    @NotNull
    @Length(min=3, max=20,
            message = "Password should be between 3 and 20 characters.")
    private String password;

    @Length(min=3, max=20,
            message = "ConfirmPassword should be same as a password.")
    private String confirmPassword;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotBlank
    @Email(message = "Email should be valid.")
    private String email;

    @NotNull
    private String phoneNumber;


    private List<Role> roles = new ArrayList<>();


    private Country country;

    public UserRegisterDTO() {
    }


//    public String getUsername() {
//        return username;
//    }
//
//    public UserRegisterDTO setUsername(String username) {
//        this.username = username;
//        return this;
//    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserRegisterDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public UserRegisterDTO setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public UserRegisterDTO setCountry(Country country) {
        this.country = country;
        return this;
    }
}
