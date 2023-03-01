package com.example.adorablepet.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pages")
public class PageController {

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
}
