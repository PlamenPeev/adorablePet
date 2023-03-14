package com.example.adorablepet.service;

import com.example.adorablepet.models.dtos.ManipulationEntityDTO;
import com.example.adorablepet.models.dtos.TypeOfManipulationDTO;
import com.example.adorablepet.models.entities.ManipulationEntity;
import com.example.adorablepet.models.entities.TypeOfManipulation;
import com.example.adorablepet.repository.ManipulationEntityRepository;
import com.example.adorablepet.repository.TypeOfManipulationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeOfManipulationService {

    private final ManipulationEntityRepository manipulationRepository;
    private final TypeOfManipulationRepository typeOfManipulationRepository;

    public TypeOfManipulationService(ManipulationEntityRepository manipulationRepository,
                                     TypeOfManipulationRepository typeOfManipulationRepository) {
        this.manipulationRepository = manipulationRepository;
        this.typeOfManipulationRepository = typeOfManipulationRepository;
    }

    public long createTypeOfManipulation(TypeOfManipulationDTO newType) {
        String typeName = newType.getType().getName();
        Optional<ManipulationEntity> typeOpt = this.manipulationRepository.
                findManipulationEntityByName(typeName);

        TypeOfManipulation newTypeOfManipulation = new TypeOfManipulation().
                setTitle(newType.getTitle()).
                setPrice(newType.getPrice()).
                setType(typeOpt.orElseGet(() -> createNewType(typeName)));

        return typeOfManipulationRepository.save(newTypeOfManipulation).getId();
    }

    private ManipulationEntity createNewType(String typeName) {
        return manipulationRepository.save(new ManipulationEntity().setName(typeName));
    }


    public Optional<TypeOfManipulationDTO> findTypeOfManipulationById(Long typeId) {
        return typeOfManipulationRepository.
                findById(typeId).
                map(this::map);
    }

    public List<TypeOfManipulationDTO> getAllTypes() {
        return typeOfManipulationRepository.findAll().
                stream().
                map(this::map).
                toList();
    }

    private TypeOfManipulationDTO map(TypeOfManipulation typeOfManipulation) {

        ManipulationEntityDTO manipulationEntityDTO = new ManipulationEntityDTO().
                setName(typeOfManipulation.getType().getName());

        return new TypeOfManipulationDTO().
                setId(typeOfManipulation.getId()).
                setType(manipulationEntityDTO).
                setPrice(typeOfManipulation.getPrice()).
                setTitle(typeOfManipulation.getTitle());
    }

}
