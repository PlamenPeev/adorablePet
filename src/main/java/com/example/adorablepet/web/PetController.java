package com.example.adorablepet.web;

import com.example.adorablepet.models.dtos.PetAddDTO;
import com.example.adorablepet.models.entities.ObjectNotFoundException;
import com.example.adorablepet.models.entities.Pet;
import com.example.adorablepet.models.service.PetServiceModel;
import com.example.adorablepet.service.PetService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;
    private final ModelMapper modelMapper;
    private final UserDetailsService userDetailsService;

    public PetController(PetService petService, ModelMapper modelMapper,
                         UserDetailsService userDetailsService) {
        this.petService = petService;
        this.modelMapper = modelMapper;
        this.userDetailsService = userDetailsService;
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
                             RedirectAttributes redirectAttributes,
                             @AuthenticationPrincipal UserDetails loggedUser) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("petAddDTO", petAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.petAddDTO", bindingResult);

            return "redirect:add";
        }

        this.petService.addPet(this.modelMapper
                .map(petAddDTO, PetServiceModel.class));

              return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getPetById(@PathVariable("id") Long id) {
        throw new ObjectNotFoundException(id, "Pet");
    }

    @GetMapping("/remove/{id}")
    public String delete(@PathVariable Long id){
        this.petService.remove(id);
        return "redirect:/";
    }

//    @GetMapping("/confirm/{id}")
//    public String confirm(@PathVariable Long id){
//        this.petService.confirm(id);
//        return "redirect:/";
//    }

}
