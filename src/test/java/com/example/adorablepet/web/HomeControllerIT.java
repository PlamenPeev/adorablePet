package com.example.adorablepet.web;

import com.example.adorablepet.models.entities.Pet;
import com.example.adorablepet.models.entities.TypeOfHelp;
import com.example.adorablepet.models.entities.UserEntity;
import com.example.adorablepet.models.enums.ChippedEnumName;
import com.example.adorablepet.models.enums.TypeOfAnimalEnumName;
import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import com.example.adorablepet.models.user.AdorablePetUserDetails;
import com.example.adorablepet.models.views.PetViewModel;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PetService petServiceTest;

    @MockBean
    private TypeOfHelp mockTypeOfHelp;

    @MockBean
    private UserEntity mockOwner;

//    @Test
//    public void testMyPetsPageShown() throws Exception {
//        mockMvc.perform(get("/pages/my-pets")).
//                andExpect(status().isOk()).
//                andExpect(view().name("pages/my-pets"));
//    }
//
//    @Test
//    public void testModeratorsPageShown() throws Exception {
//        mockMvc.perform(get("/pages/moderators")).
//                andExpect(status().isOk()).
//                andExpect(view().name("pages/moderators"));
//    }

//    @Test
//    public void testAdminsPageShown() throws Exception {
//        mockMvc.perform(get("/pages/admins")).
//                andExpect(status().isOk()).
//                andExpect(view().name("pages/admins"));
//    }

    @Test
    public void testMyPets() throws Exception {
        AdorablePetUserDetails userDetails = new AdorablePetUserDetails(
                1L, "12345", "johny","John", "Doe",
                "087654321","Bulgaria", Collections.emptyList());

        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, "password", userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);

        List<PetViewModel> expectedPets = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setId(1L);
        pet1.setName("Fluffy");
        pet1.setAge(2.5);
        pet1.setChippedEnumName(ChippedEnumName.YES);
        pet1.setTypeOfAnimalEnumName(TypeOfAnimalEnumName.CAT);
        pet1.setTypeOfHelp(mockTypeOfHelp);
        pet1.setOwner(mockOwner);
        pet1.setDate(LocalDate.now());
        pet1.setHourOfVisit(15);

        Pet pet2 = new Pet();
        pet2.setId(2L);
        pet2.setName("Viking");
        pet2.setAge(4.0);
        pet2.setChippedEnumName(ChippedEnumName.YES);
        pet2.setTypeOfAnimalEnumName(TypeOfAnimalEnumName.DOG);
        pet2.setTypeOfHelp(mockTypeOfHelp);
        pet2.setOwner(mockOwner);
        pet2.setDate(LocalDate.now());
        pet2.setHourOfVisit(11);

        expectedPets.add(new PetViewModel(pet1));
        expectedPets.add(new PetViewModel(pet2));

        when(petServiceTest.findPetsByUsername(auth.getName(), TypeOfHelpEnumName.TREATMENT)).thenReturn(expectedPets);
        when(petServiceTest.findPetsByUsername(auth.getName(), TypeOfHelpEnumName.GROOMING)).thenReturn(expectedPets);
        when(petServiceTest.findPetsByUsername(auth.getName(), TypeOfHelpEnumName.HOTEL)).thenReturn(expectedPets);
        when(petServiceTest.findPetsByUsername(auth.getName(), TypeOfHelpEnumName.SCHOOL)).thenReturn(expectedPets);
        when(petServiceTest.findPetsByUsername(auth.getName(), TypeOfHelpEnumName.PREVENTION)).thenReturn(expectedPets);
        when(petServiceTest.findPetsByOwner(auth.getName())).thenReturn(1L);

        mockMvc.perform(get("/pages/my-pets")
                        .principal(new UsernamePasswordAuthenticationToken(auth, "password")))
                .andExpect(status().isOk())
                .andExpect(view().name("pages/my-pets"))
                .andExpect(model().attribute("treatments", expectedPets))
                .andExpect(model().attribute("grooms", expectedPets))
                .andExpect(model().attribute("hotels", expectedPets))
                .andExpect(model().attribute("schools", expectedPets))
                .andExpect(model().attribute("preventions", expectedPets));
//                .andExpect(model().attribute("numVisitByUser", 1L))
//                .andExpect(model().attribute("user", "testUser"));
    }

    @Test
    public void testPageModerators() throws Exception {
        List<PetViewModel> expectedPets = new ArrayList<>();
        expectedPets.add(new PetViewModel());
        expectedPets.add(new PetViewModel());

        when(petServiceTest.findPets(TypeOfHelpEnumName.TREATMENT)).thenReturn(expectedPets);
        when(petServiceTest.findPets(TypeOfHelpEnumName.GROOMING)).thenReturn(expectedPets);
        when(petServiceTest.findPets(TypeOfHelpEnumName.HOTEL)).thenReturn(expectedPets);
        when(petServiceTest.findPets(TypeOfHelpEnumName.SCHOOL)).thenReturn(expectedPets);
        when(petServiceTest.findPets(TypeOfHelpEnumName.PREVENTION)).thenReturn(expectedPets);
        when(petServiceTest.countAllPets()).thenReturn(10L);

        mockMvc.perform(MockMvcRequestBuilders.
                        get("/pages/moderators"))
                .andExpect(status().isOk())
                .andExpect(view().name("pages/moderators"))
                .andExpect(model().attribute("treatments", expectedPets))
                .andExpect(model().attribute("grooms", expectedPets))
                .andExpect(model().attribute("hotels", expectedPets))
                .andExpect(model().attribute("schools", expectedPets))
                .andExpect(model().attribute("preventions", expectedPets))
                .andExpect(model().attribute("countOfPets", 10L));
    }

    @Test
    public void testPageAdmins() throws Exception {
        List<PetViewModel> expectedPets = new ArrayList<>();
        expectedPets.add(new PetViewModel());
        expectedPets.add(new PetViewModel());

        when(petServiceTest.findPets(TypeOfHelpEnumName.TREATMENT)).thenReturn(expectedPets);
        when(petServiceTest.findPets(TypeOfHelpEnumName.GROOMING)).thenReturn(expectedPets);
        when(petServiceTest.findPets(TypeOfHelpEnumName.HOTEL)).thenReturn(expectedPets);
        when(petServiceTest.findPets(TypeOfHelpEnumName.SCHOOL)).thenReturn(expectedPets);
        when(petServiceTest.findPets(TypeOfHelpEnumName.PREVENTION)).thenReturn(expectedPets);
        when(petServiceTest.countAllPets()).thenReturn(10L);

        mockMvc.perform(get("/pages/admins"))
                .andExpect(status().isOk())
                .andExpect(view().name("pages/admins"))
                .andExpect(model().attribute("treatments", expectedPets))
                .andExpect(model().attribute("grooms", expectedPets))
                .andExpect(model().attribute("hotels", expectedPets))
                .andExpect(model().attribute("schools", expectedPets))
                .andExpect(model().attribute("preventions", expectedPets))
                .andExpect(model().attribute("countOfPets", 10L));
    }


}
