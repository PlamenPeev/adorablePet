package com.example.adorablepet.web;

import com.example.adorablepet.models.entities.Pet;
import com.example.adorablepet.models.entities.UserEntity;
import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import com.example.adorablepet.models.views.PetViewModel;
import com.example.adorablepet.repository.PetRepository;
import com.example.adorablepet.service.PetService;
import com.example.adorablepet.service.UserService;
import com.example.adorablepet.session.CurrentUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


//@Controller
//@RequestMapping("pages")
//public class HomeController {
//
//    private final PetService petService;
//    private final UserService userService;
//    private final PetRepository petRepository;
//    private final CurrentUser currentUser;
//
//    public HomeController(PetService petService, UserService userService, PetRepository petRepository, CurrentUser currentUser) {
//        this.petService = petService;
//        this.userService = userService;
//        this.petRepository = petRepository;
//        this.currentUser = currentUser;
//    }
//
//    @GetMapping("/my-pets")
//    public String index(Model model) {
//
////        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////
////        if (principal.getUsername() == null) {
////            return "index";
////        }
//
//      //
////
////        if (user.getId() == null) {
////            return "index";
////        }
//
//        if (currentUser.getId() == null) {
//            return "index";
//        }
//
//        String userMail = currentUser.getEmail();
//
//
//        List<Pet> allPets = this.petRepository.findAll();
//        List<Pet> petsByUser = this.petRepository.findUserByEmail(userMail);
//
//
//        List<PetViewModel> treatments = this.petService.findAllByTypeOfHelp(TypeOfHelpEnumName.TREATMENT);
//        List<PetViewModel> grooms = this.petService.findAllByTypeOfHelp(TypeOfHelpEnumName.GROOMING);
//        List<PetViewModel> hotels = this.petService.findAllByTypeOfHelp(TypeOfHelpEnumName.HOTEL);
//        List<PetViewModel> schools = this.petService.findAllByTypeOfHelp(TypeOfHelpEnumName.SCHOOL);
//        List<PetViewModel> preventions = this.petService.findAllByTypeOfHelp(TypeOfHelpEnumName.PREVENTION);
//
//
//
//        model.addAttribute("treatments", treatments);
//        model.addAttribute("grooms", grooms);
//        model.addAttribute("hotels", hotels);
//        model.addAttribute("schools", schools);
//        model.addAttribute("preventions", preventions);
//        model.addAttribute("totalCount", allPets
//                .stream()
//                .map(Pet::getAge)
//                .reduce(Double::sum)
//                .orElse(Double.valueOf(0.0)));
//        model.addAttribute("petsByUser", petsByUser);
//
//        return "pages/my-pets";
//    }


//}
