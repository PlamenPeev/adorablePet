package com.example.adorablepet.service;

import com.example.adorablepet.models.entities.Pet;
import com.example.adorablepet.models.service.PetServiceModel;
import com.example.adorablepet.repository.PetRepository;
import com.example.adorablepet.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class PetService {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final PetRepository petRepository;
    private final TypeOfHelpService typeOfHelpService;



    public PetService(ModelMapper modelMapper, UserService userService,
                      CurrentUser currentUser, PetRepository petRepository,
                      TypeOfHelpService typeOfHelpService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.currentUser = currentUser;
        this.petRepository = petRepository;
        this.typeOfHelpService = typeOfHelpService;
    }



//    public void addPet(PetAddDTO petAddDTO, UserDetailsService userDetailsService) {
//        Pet pet = new Pet();
//        pet.setOwner(this.userService.findUserByEmail(currentUser.getEmail()));
//        pet.setTypeOfHelp(this.typeOfHelpService.
//                findTypeOfHelpByTypeOfHelpEnumName(TypeOfHelpEnumName.
//                        valueOf(petAddDTO.getTypeOfHelp().name())));
//
//        this.petRepository.save(pet);
//    }



   public void addPet( PetServiceModel petServiceModel) {
        Pet pet = modelMapper
                .map(petServiceModel, Pet.class);

        pet.setOwner(userService.findUserByEmail(currentUser.getEmail()));
        pet.setTypeOfHelp(typeOfHelpService
                .findByTypeOfHelpEnumName(
                        petServiceModel.getTypeOfHelp().getTypeOfHelpEnumName()));

        this.petRepository.save(pet);
    }


}
