package com.example.adorablepet.repository;

import com.example.adorablepet.models.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {

    Optional<Pet> findPetByChippedEnumName(Pet pet);
    Optional<Pet> findPetsByTypeOfAnimalEnumName (Pet pet);
    Optional<Pet> findPetsByOwner (Pet pet);

}
