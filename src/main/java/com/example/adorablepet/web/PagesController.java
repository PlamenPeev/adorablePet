package com.example.adorablepet.web;

import com.example.adorablepet.models.entities.ObjectNotFoundException;
import com.example.adorablepet.repository.PetRepository;
import com.example.adorablepet.service.PetService;
import com.example.adorablepet.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pages")
public class PagesController {

    private final PetService petService;
    private final UserService userService;
    private final PetRepository petRepository;


    public PagesController(PetService petService, UserService userService, PetRepository petRepository) {
        this.petService = petService;
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

    @GetMapping("/{id}")
    public String getPageById(@PathVariable("id") Long id) {
        throw new ObjectNotFoundException(id, "Page");
    }
}
