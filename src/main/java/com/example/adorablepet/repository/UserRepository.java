package com.example.adorablepet.repository;

import com.example.adorablepet.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByEmail(String email);
    Optional<UserEntity> findUserById(Long id);



    @Query("SELECT u FROM UserEntity u WHERE u.email = :currentMail GROUP BY size(u.pets)")
    List<UserEntity> findAllByPetsCount(@Param("currentMail") String mail);



}
