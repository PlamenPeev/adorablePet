package com.example.adorablepet.repository;

import com.example.adorablepet.models.entities.ManipulationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManipulationEntityRepository extends JpaRepository<ManipulationEntity, Long> {

    Optional<ManipulationEntity> findManipulationEntityByName(String name);
}
