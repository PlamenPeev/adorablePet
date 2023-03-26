package com.example.adorablepet.repository;

import com.example.adorablepet.models.entities.Pet;
import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {

    Optional<Pet> findPetByChippedEnumName(Pet pet);
    Optional<Pet> findPetsByTypeOfAnimalEnumName (Pet pet);
    Optional<Pet> findPetsByOwner (Pet pet);

   List<Pet> findPetsByTypeOfHelp_TypeOfHelpEnumName(TypeOfHelpEnumName name);

    @Query("SELECT p FROM Pet AS p GROUP BY p.owner.email")
    List<Pet> findUserByEmail(String email);

//    @Query("SELECT p FROM Pet AS p GROUP BY p.typeOfHelp.typeOfHelpEnumName")
//    List<Pet> findPetsByTypeOfHelpEnumName(TypeOfHelpEnumName name);

    @Query("SELECT p FROM Pet p GROUP BY p.typeOfHelp.typeOfHelpEnumName")
    List<Pet> findPetsByTypeOfHelp(TypeOfHelpEnumName name);

@Query("SELECT p FROM Pet p Group by p.typeOfHelp.typeOfHelpEnumName")
    List<Pet> findAllByTypeOfHelp();
//
//    @Query("SELECT p FROM Pet p GROUP BY p.owner, p.typeOfHelp.typeOfHelpEnumName")
//    List<Pet> findAllByUserByTypeOfHelp(String username, TypeOfHelpEnumName name);




    List<Pet> findAllByOwner_EmailAndTypeOfHelp_TypeOfHelpEnumName(String email, TypeOfHelpEnumName name);

    @Query("SELECT COUNT(p.id) FROM Pet p WHERE p.owner.email = :currentMail")
    List<Pet> findPetsByOwner(@Param("currentMail") String mail);
}