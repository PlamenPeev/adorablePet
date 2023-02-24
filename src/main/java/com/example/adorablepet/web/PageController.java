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

    @GetMapping("/good-heart")
    private String goodHeart(){
        return "pages/good-heart";
    }

    @GetMapping("/projects")
    private String projects(){
        return "pages/projects";
    }
}
