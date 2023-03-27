package com.example.adorablepet.repository;

import com.example.adorablepet.models.entities.Pet;
import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {


    @Query("SELECT p FROM Pet AS p GROUP BY p.owner.email")
    List<Pet> findUserByEmail(String email);



//TODO: Working true
    List<Pet> findPetsByTypeOfHelp_TypeOfHelpEnumName(TypeOfHelpEnumName name);

    List<Pet> findAllByOwner_EmailAndTypeOfHelp_TypeOfHelpEnumName(String email, TypeOfHelpEnumName name);

    @Query("SELECT COUNT(p.id) FROM Pet p WHERE p.owner.email = :currentMail")
    Long findPetsByOwner(@Param("currentMail") String mail);

    @Query("SELECT COUNT(p.id) FROM Pet p")
    Long countAllPets();

    void deleteByDateBefore(LocalDate thresholdDate);
}