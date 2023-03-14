package com.example.adorablepet.repository;

import com.example.adorablepet.models.dtos.TypeOfManipulationDTO;
import com.example.adorablepet.models.entities.TypeOfManipulation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeOfManipulationRepository extends JpaRepository<TypeOfManipulation, Long> {

    Optional<TypeOfManipulationDTO> findTypeOfManipulationById(Long typeId);
}
