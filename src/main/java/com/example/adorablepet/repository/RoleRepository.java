package com.example.adorablepet.repository;

import com.example.adorablepet.models.entities.Role;
import com.example.adorablepet.models.enums.RoleEnumName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findRoleByRoleEnumName(RoleEnumName role);
}
