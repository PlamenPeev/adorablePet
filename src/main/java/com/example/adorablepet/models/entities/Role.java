package com.example.adorablepet.models.entities;

import com.example.adorablepet.models.enums.RoleEnumName;
import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role extends BaseEntity{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnumName roleEnumName;

    @Column(columnDefinition = "TEXT")
    private String description;



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


}
