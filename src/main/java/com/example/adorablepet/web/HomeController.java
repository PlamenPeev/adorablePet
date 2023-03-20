package com.example.adorablepet.web;

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

import java.util.List;


@Controller
public class HomeController {

    private final PetService petService;
    private final UserService userService;
    private final PetRepository petRepository;
    private final CurrentUser currentUser;

    public HomeController(PetService petService, UserService userService, PetRepository petRepository, CurrentUser currentUser) {
        this.petService = petService;
        this.userService = userService;
        this.petRepository = petRepository;
        this.currentUser = currentUser;
    }

    @GetMapping("/home")
    public String index(Model model) {

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal.getUsername() == null) {
            return "index";
        }

//        if (currentUser.getId() == null) {
//            return "index";
//        }
//
//        long userId = currentUser.getId();


//        List<Pet> allPets = this.petRepository.findAll();
//        List<Pet> petsByUser = this.petRepository.findUserByEmail(principal.getUsername());


        List<PetViewModel> treatments = this.petService.findAllByTypeOfHelp(TypeOfHelpEnumName.TREATMENT);
        List<PetViewModel> grooms = this.petService.findAllByTypeOfHelp(TypeOfHelpEnumName.GROOMING);
        List<PetViewModel> hotels = this.petService.findAllByTypeOfHelp(TypeOfHelpEnumName.HOTEL);
        List<PetViewModel> schools = this.petService.findAllByTypeOfHelp(TypeOfHelpEnumName.SCHOOL);
        List<PetViewModel> preventions = this.petService.findAllByTypeOfHelp(TypeOfHelpEnumName.PREVENTION);


        model.addAttribute("treatments", treatments);
        model.addAttribute("grooms", grooms);
        model.addAttribute("hotels", hotels);
        model.addAttribute("schools", schools);
        model.addAttribute("preventions", preventions);
//        model.addAttribute("totalCount", allPets
//                .stream()
//                .map(Pet::getAge)
//                .reduce(Double::sum)
//                .orElse(Double.valueOf(0.0)));
//        model.addAttribute("petsByUser", petsByUser);

        return "home";
    }
}
