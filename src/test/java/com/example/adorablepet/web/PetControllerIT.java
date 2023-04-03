package com.example.adorablepet.web;

import com.example.adorablepet.models.dtos.PetAddDTO;
import com.example.adorablepet.models.enums.ChippedEnumName;
import com.example.adorablepet.models.enums.TypeOfAnimalEnumName;
import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import com.example.adorablepet.models.service.PetServiceModel;
import com.example.adorablepet.models.user.AdorablePetUserDetails;
import com.example.adorablepet.service.PetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PetControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PetService petServiceTest;


    @Test
    void testAddPet() throws Exception {
        AdorablePetUserDetails userDetails = new AdorablePetUserDetails(
                1L, "12345", "johny","John", "Doe",
                "087654321","Bulgaria", Collections.emptyList());


        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, "password", userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);


        PetAddDTO petAddDTO = new PetAddDTO();
        petAddDTO.setName("Viking");
        petAddDTO.setAge(2.0);
        petAddDTO.setChippedEnumName(ChippedEnumName.YES);
        petAddDTO.setTypeOfAnimalEnumName(TypeOfAnimalEnumName.DOG);
        petAddDTO.setTypeOfHelp(TypeOfHelpEnumName.GROOMING);
        petAddDTO.setDate(LocalDate.now());
        petAddDTO.setHourOfVisit(10);


        this.mockMvc.perform(post("/pets/add")
                        .param("name", petAddDTO.getName())
                        .param("age", petAddDTO.getAge().toString())
                        .param("chippedEnumName", petAddDTO.getChippedEnumName().toString())
                        .param("typeOfAnimalEnumName", petAddDTO.getTypeOfAnimalEnumName().toString())
                        .param("typeOfHelp", petAddDTO.getTypeOfHelp().toString())
                        .param("owner", auth.getName())
                        .param("date", String.valueOf(LocalDate.now()))
                        .param("hourOfVisit", "10")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

        verify(petServiceTest, times(1))
                .addPet(any(PetServiceModel.class));
    }


    @Test
    void testAddInvalidPet() throws Exception {
        AdorablePetUserDetails userDetails = new AdorablePetUserDetails(
                1L, "12345", "johny","John", "Doe",
                "087654321","Bulgaria", Collections.emptyList());

        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, "password", userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);

        this.mockMvc.perform(post("/pets/add")
                        .param("name", "D")
                        .param("age", "2.0")
                        .param("chippedEnumName", String.valueOf(ChippedEnumName.YES))
                        .param("typeOfAnimalEnumName", String.valueOf(TypeOfAnimalEnumName.DOG))
                        .param("typeOfHelp", String.valueOf(TypeOfHelpEnumName.GROOMING))
                        .param("owner", auth.getName())
                        .param("date", String.valueOf(LocalDate.now()))
                        .param("hourOfVisit", "23")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("add"));
    }


    @Test
    public void testPetAddPageShown() throws Exception {
        mockMvc.perform(get("/pets/add"))
               .andExpect(status().isOk())
                .andExpect(view().name("pets/add"));

    }


}
