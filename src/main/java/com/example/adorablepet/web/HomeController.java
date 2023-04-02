package com.example.adorablepet.web;

import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import com.example.adorablepet.models.views.PetViewModel;
import com.example.adorablepet.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    private final PetService petService;

    public HomeController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pages/my-pets")

    public String MyPets(Model model, Principal principal) {

        if (principal.getName() == null) {
            return "index";
        }

        List<PetViewModel> treatments = this.petService.findPetsByUsername(principal.getName(), TypeOfHelpEnumName.TREATMENT);
        List<PetViewModel> grooms = this.petService.findPetsByUsername(principal.getName(),TypeOfHelpEnumName.GROOMING);
        List<PetViewModel> hotels = this.petService.findPetsByUsername(principal.getName(),TypeOfHelpEnumName.HOTEL);
        List<PetViewModel> schools = this.petService.findPetsByUsername(principal.getName(),TypeOfHelpEnumName.SCHOOL);
        List<PetViewModel> preventions = this.petService.findPetsByUsername(principal.getName(),TypeOfHelpEnumName.PREVENTION);
        Long numVisitByUser = this.petService.findPetsByOwner(principal.getName());

        model.addAttribute("treatments", treatments);
        model.addAttribute("grooms", grooms);
        model.addAttribute("hotels", hotels);
        model.addAttribute("schools", schools);
        model.addAttribute("preventions", preventions);
        model.addAttribute("numVisitByUser", numVisitByUser);
        model.addAttribute("user", principal.getName());


        return "pages/my-pets";
    }

    @GetMapping("/pages/moderators")
    private String pageModerators(Model model){


        List<PetViewModel> treatments = this.petService.findPets(TypeOfHelpEnumName.TREATMENT);
        List<PetViewModel> grooms = this.petService.findPets(TypeOfHelpEnumName.GROOMING);
        List<PetViewModel> hotels = this.petService.findPets(TypeOfHelpEnumName.HOTEL);
        List<PetViewModel> schools = this.petService.findPets(TypeOfHelpEnumName.SCHOOL);
        List<PetViewModel> preventions = this.petService.findPets(TypeOfHelpEnumName.PREVENTION);
        Long countOfPets = this.petService.countAllPets();

        model.addAttribute("treatments", treatments);
        model.addAttribute("grooms", grooms);
        model.addAttribute("hotels", hotels);
        model.addAttribute("schools", schools);
        model.addAttribute("preventions", preventions);
        model.addAttribute("countOfPets", countOfPets);


        return "pages/moderators";
    }

    @GetMapping("/pages/admins")
    public String pageAdmins(Model model) {


        List<PetViewModel> treatments = this.petService.findPets(TypeOfHelpEnumName.TREATMENT);
        List<PetViewModel> grooms = this.petService.findPets(TypeOfHelpEnumName.GROOMING);
        List<PetViewModel> hotels = this.petService.findPets(TypeOfHelpEnumName.HOTEL);
        List<PetViewModel> schools = this.petService.findPets(TypeOfHelpEnumName.SCHOOL);
        List<PetViewModel> preventions = this.petService.findPets(TypeOfHelpEnumName.PREVENTION);
        Long countOfPets = this.petService.countAllPets();


        model.addAttribute("treatments", treatments);
        model.addAttribute("grooms", grooms);
        model.addAttribute("hotels", hotels);
        model.addAttribute("schools", schools);
        model.addAttribute("preventions", preventions);
        model.addAttribute("countOfPets", countOfPets);



        return "pages/admins";
    }

}
