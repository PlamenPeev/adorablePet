package com.example.adorablepet.web;

import com.example.adorablepet.models.entities.ObjectNotFoundException;
import com.example.adorablepet.models.entities.Pet;
import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import com.example.adorablepet.models.views.PetViewModel;
import com.example.adorablepet.models.views.UserViewModel;
import com.example.adorablepet.repository.PetRepository;
import com.example.adorablepet.service.PetService;
import com.example.adorablepet.service.UserService;
import com.example.adorablepet.session.CurrentUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/pages")
public class PagesController {

    private final PetService petService;
    private final UserService userService;
    private final PetRepository petRepository;
    private final CurrentUser currentUser;

    public PagesController(PetService petService, CurrentUser currentUser,
                           HttpSession httpSession, UserService userService, PetRepository petRepository) {
        this.petService = petService;
        this.currentUser = currentUser;
        this.userService = userService;
        this.petRepository = petRepository;
    }

    @GetMapping("/departments")
    private String departments(){
        return "pages/departments";
    }

    @GetMapping("/departments-more-info")
    private String departmentsMoreInfo(){
        return "pages/departments-more-info";
    }

    @GetMapping("/our-team")
    private String ourTeam(){
        return "pages/our-team";
    }

    @GetMapping("/information")
    private String information(){
        return "pages/information";
    }

    @GetMapping("/price-list")
    private String priceList(){
        return "pages/price-list";
    }

    @GetMapping("/clinic-services")
    private String clinicServices(){
        return "pages/clinic-services";
    }


    @GetMapping("/good-heart")
    private String goodHeart(){
        return "pages/good-heart";
    }

    @GetMapping("/projects")
    private String projects(){

        return "pages/projects";
    }


    @GetMapping("/my-pets")

    public String MyPets(Model model,Principal principal) {

        if (principal.getName() == null) {
            return "index";
        }


        List<PetViewModel> treatments = this.petService.findPetsByUsername(principal.getName(),TypeOfHelpEnumName.TREATMENT);
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


        return "pages/my-pets";
    }

    @GetMapping("/moderators")
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

    @GetMapping("/admins")
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


    @GetMapping("/{id}")
    public String getPageById(@PathVariable("id") Long id) {
        throw new ObjectNotFoundException(id, "Page");
    }
}
