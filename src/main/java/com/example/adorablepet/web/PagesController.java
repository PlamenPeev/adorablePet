package com.example.adorablepet.web;

import com.example.adorablepet.models.entities.ObjectNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pages")
public class PagesController {


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

    @GetMapping("/admins")
    private String admin(){

        return "pages/admins";
    }

    @GetMapping("/moderators")
    private String moderator(){

        return "pages/moderators";
    }

    @GetMapping("/my-pets")
    private String myPets(){

        return "home";
    }

//    @GetMapping("/{id}")
//    public String getPageById(@PathVariable("id") Long id) {
//        throw new ObjectNotFoundException(id, "Page");
//    }
}
