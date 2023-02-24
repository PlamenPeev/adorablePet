package com.example.adorablepet.models.entities;

import com.example.adorablepet.models.enums.RoleEnumName;
import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private RoleEnumName roleEnumName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToOne
    private User user;

    public Role() {
    }

    public RoleEnumName getRoleEnumName() {
        return roleEnumName;
    }

    public Role setRoleEnumName(RoleEnumName roleEnumName) {
        this.roleEnumName = roleEnumName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Role setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Role setUser(User user) {
        this.user = user;
        return this;
    }
}
