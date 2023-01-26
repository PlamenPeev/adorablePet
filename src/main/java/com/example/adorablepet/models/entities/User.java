package com.example.adorablepet.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column
    private String username;

    @Column
    private String password;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Column
    private String email;

    @Column(name ="phone_number")
    private String phoneNumber;
}
