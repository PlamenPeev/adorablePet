package com.example.adorablepet.web;

import com.example.adorablepet.models.dtos.PetAddDTO;
import com.example.adorablepet.models.service.PetServiceModel;
import com.example.adorablepet.service.PetService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;
    private final ModelMapper modelMapper;

    public PetController(PetService petService, ModelMapper modelMapper) {
        this.petService = petService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("petAddDTO")) {
            model.addAttribute("petAddDTO", new PetAddDTO());
        }
        return "pet-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("petAddDTO")
                             PetAddDTO petAddDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("petAddDTO", petAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.petAddDTO", bindingResult);

            return "redirect:add";
        }


        this.petService.addPet(this.modelMapper
                .map(petAddDTO, PetServiceModel.class));

        return "redirect:/";
    }
}
