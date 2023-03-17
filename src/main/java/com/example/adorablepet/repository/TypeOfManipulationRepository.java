package com.example.adorablepet.repository;

import com.example.adorablepet.models.dtos.TypeOfManipulationDTO;
import com.example.adorablepet.models.entities.TypeOfManipulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeOfManipulationRepository extends JpaRepository<TypeOfManipulation, Long> {

    Optional<TypeOfManipulationDTO> findTypeOfManipulationById(Long typeId);
}
