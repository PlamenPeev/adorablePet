package com.example.adorablepet.service;

import com.example.adorablepet.models.entities.Pet;
import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import com.example.adorablepet.models.service.PetServiceModel;
import com.example.adorablepet.models.views.PetViewModel;
import com.example.adorablepet.repository.PetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final PetRepository petRepository;
    private final TypeOfHelpService typeOfHelpService;


    public PetService(ModelMapper modelMapper, UserService userService, PetRepository petRepository,
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


    public List<PetViewModel> findAllByTypeOfHelp(TypeOfHelpEnumName name){
        return this.petRepository.findPetsByTypeOfHelp(name)
                .stream()
                .map(pet -> modelMapper
                        .map(pet, PetViewModel.class))
                .collect(Collectors.toList());
    }



//    public List<PetViewModel> findAllByUser(String username, TypeOfHelpEnumName name){
//        return this.petRepository.findAllByUserByTypeOfHelp(username, name)
//                .stream()
//                .map(pet -> modelMapper
//                        .map(pet, PetViewModel.class))
//                .collect(Collectors.toList());
//    }

    public void remove(Long id) {
        petRepository
                .deleteById(id);
    }

}
