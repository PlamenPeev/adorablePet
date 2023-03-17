package com.example.adorablepet.service;

import com.example.adorablepet.models.entities.Pet;
import com.example.adorablepet.models.service.PetServiceModel;
import com.example.adorablepet.repository.PetRepository;
import com.example.adorablepet.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final PetRepository petRepository;
    private final TypeOfHelpService typeOfHelpService;
    private final ApplicationUserDetailsService applicationUserDetailsService;



    public PetService(ModelMapper modelMapper, UserService userService,
                      CurrentUser currentUser, PetRepository petRepository,
                      TypeOfHelpService typeOfHelpService,
                      ApplicationUserDetailsService applicationUserDetailsService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.currentUser = currentUser;
        this.petRepository = petRepository;
        this.typeOfHelpService = typeOfHelpService;
        this.applicationUserDetailsService = applicationUserDetailsService;
    }



   public void addPet( PetServiceModel petServiceModel) {
        Pet pet = modelMapper
                .map(petServiceModel, Pet.class);


        pet.setOwner(userService.findUserByEmail(currentUser.getEmail()));
        //pet.setOwner(userService.findUserById(currentUser.getId()));
        pet.setTypeOfHelp(typeOfHelpService
                .findByTypeOfHelpEnumName(
                        petServiceModel.getTypeOfHelp().getTypeOfHelpEnumName()));

        this.petRepository.save(pet);
    }


}
