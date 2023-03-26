package com.example.adorablepet.service;

import com.example.adorablepet.models.entities.Pet;
import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import com.example.adorablepet.models.service.PetServiceModel;
import com.example.adorablepet.models.views.PetViewModel;
import com.example.adorablepet.models.views.UserViewModel;
import com.example.adorablepet.repository.PetRepository;
import com.example.adorablepet.repository.UserRepository;
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
    private final UserRepository userRepository;


    public PetService(ModelMapper modelMapper, UserService userService, PetRepository petRepository,
                      TypeOfHelpService typeOfHelpService, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.petRepository = petRepository;
        this.typeOfHelpService = typeOfHelpService;
        this.userRepository = userRepository;
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

    public List<PetViewModel> findAllPets() {

        return this.petRepository
                .findAllByTypeOfHelp()
                .stream()
                .map(pet -> {
                    PetViewModel petViewModel= this.modelMapper
                            .map(pet, PetViewModel.class);
                    return petViewModel;
                })
                .collect(Collectors.toList());

    }


        public List<PetViewModel> findPetsByUsername(String email,TypeOfHelpEnumName name) {
            return this.petRepository.findAllByOwner_EmailAndTypeOfHelp_TypeOfHelpEnumName(email,name)
                    .stream()
                    .map(pet -> {
                        PetViewModel petViewModel= this.modelMapper
                                .map(pet, PetViewModel.class);
                        return petViewModel;
                    })
                    .collect(Collectors.toList());

    }

    public List<PetViewModel> findPets(TypeOfHelpEnumName name) {
        return this.petRepository
                .findPetsByTypeOfHelp_TypeOfHelpEnumName(name)
                .stream()
                .map(pet -> {
                    PetViewModel petViewModel= this.modelMapper
                            .map(pet, PetViewModel.class);
                    return petViewModel;
                })
                .collect(Collectors.toList());

    }




    public List<PetViewModel> findPetsByOwner(String mail){
        return this.petRepository
                .findPetsByOwner(mail)
                .stream()
                .map(pet -> {
                    PetViewModel petViewModel= this.modelMapper
                            .map(pet, PetViewModel.class);
                    return petViewModel;
                })
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
