package com.example.adorablepet.models.entities;

import com.example.adorablepet.models.enums.RoleEnumName;
import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role extends BaseEntity{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnumName roleEnumName;

    public Role() {
    }

    public RoleEnumName getRoleEnumName() {
        return roleEnumName;
    }

    public Role setRoleEnumName(RoleEnumName roleEnumName) {
        this.roleEnumName = roleEnumName;
        return this;
    }


}
