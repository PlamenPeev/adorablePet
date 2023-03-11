package com.example.adorablepet.models.dtos;

import com.example.adorablepet.models.entities.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.ArrayList;
import java.util.List;

public class UserRegistrationDTO {

//    @NotNull
//    @Length(min=3, max=20,
//            message = "Username should be between 3 and 20 characters.")
//        private String username;



    @NotNull
    @Length(min=2, max=20,
            message = "First name should be between 2 and 20 characters.")
    private String firstName;

    @NotNull
    @Length(min=2, max=20,
            message = "Last name should be between 2 and 20 characters.")
    private String lastName;

    @NotNull
    private String phoneNumber;

    private String country;

    @NotBlank
    @Email(message = "Email should be valid.")
    private String email;

    @NotNull
    @Length(min=3, max=20,
            message = "Password should be between 3 and 20 characters.")
    private String password;

    @Length(min=3, max=20,
            message = "ConfirmPassword should be same as a password.")
    private String confirmPassword;

    private List<Role> roles = new ArrayList<>();



    public UserRegistrationDTO() {
    }


//    public String getUsername() {
//        return username;
//    }
//
//    public UserRegisterDTO setUsername(String username) {
//        this.username = username;
//        return this;
//    }


    public String getFirstName() {
        return firstName;
    }

    public UserRegistrationDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegistrationDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserRegistrationDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserRegistrationDTO setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public UserRegistrationDTO setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }
}
