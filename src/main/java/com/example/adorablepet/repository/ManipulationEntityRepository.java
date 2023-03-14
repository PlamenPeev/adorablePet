package com.example.adorablepet.repository;

import com.example.adorablepet.models.dtos.ManipulationEntityDTO;
import com.example.adorablepet.models.entities.ManipulationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManipulationEntityRepository extends JpaRepository<ManipulationEntity, Long> {

    Optional<ManipulationEntity> findManipulationEntityByName(String name);
}
