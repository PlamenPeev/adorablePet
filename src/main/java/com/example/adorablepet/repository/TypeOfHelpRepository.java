package com.example.adorablepet.repository;

import com.example.adorablepet.models.entities.TypeOfHelp;
import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeOfHelpRepository extends JpaRepository<TypeOfHelp, Long> {

    Optional<TypeOfHelp>findTypeOfHelpByTypeOfHelpEnumName(TypeOfHelpEnumName typeOfHelpEnumName);
}
