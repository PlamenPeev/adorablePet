package com.example.adorablepet.service;

import com.example.adorablepet.models.entities.Pet;
import com.example.adorablepet.models.service.PetServiceModel;
import com.example.adorablepet.repository.PetRepository;
import com.example.adorablepet.repository.UserRepository;
import com.example.adorablepet.session.CurrentUser;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class PetService {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final PetRepository petRepository;
    private final TypeOfHelpService typeOfHelpService;





    public PetService(ModelMapper modelMapper, UserService userService,
                      CurrentUser currentUser, PetRepository petRepository,
                      TypeOfHelpService typeOfHelpService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.petRepository = petRepository;
        this.typeOfHelpService = typeOfHelpService;

    }



   public void addPet(PetServiceModel petServiceModel) {
        Pet pet = modelMapper
                .map(petServiceModel, Pet.class);

       User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

       pet.setOwner(userService.findUserByEmail(principal.getUsername()));

        pet.setTypeOfHelp(typeOfHelpService
                .findByTypeOfHelpEnumName(
                        petServiceModel.getTypeOfHelp().getTypeOfHelpEnumName()));

        this.petRepository.save(pet);
    }



}
