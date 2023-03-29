package com.example.adorablepet.service;

import com.example.adorablepet.models.entities.Pet;
import com.example.adorablepet.models.entities.TypeOfHelp;
import com.example.adorablepet.models.entities.UserEntity;
import com.example.adorablepet.models.enums.ChippedEnumName;
import com.example.adorablepet.models.enums.TypeOfAnimalEnumName;
import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import com.example.adorablepet.models.service.PetServiceModel;
import com.example.adorablepet.models.user.AdorablePetUserDetails;
import com.example.adorablepet.models.views.PetViewModel;
import com.example.adorablepet.repository.PetRepository;
import com.example.adorablepet.repository.TypeOfHelpRepository;
import com.example.adorablepet.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PetServiceTest {
    @Mock
    private ModelMapper modelMapper;

    @Mock
    private UserService mockUserService;

    @Mock
    private PetRepository mockPetRepository;

    @Mock
    private TypeOfHelpService mockTypeOfHelpService;

    @Mock
    private UserRepository mockUserRepository;

    @Mock
    private TypeOfHelpRepository mockTypeOfHelpRepository;

    private PetService petServiceTest;



    @BeforeEach
     void setUp() {
        petServiceTest = new PetService(modelMapper,mockUserService,
                mockPetRepository,mockTypeOfHelpService,mockUserRepository
        );


    }

    @Test
    public void testAddPet() {
        // Arrange
        AdorablePetUserDetails userDetails = new AdorablePetUserDetails(
                1L, "12345", "johny","John", "Doe",
                "087654321","Bulgaria", Collections.emptyList());


        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, "password", userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);

        PetServiceModel petServiceModel = new PetServiceModel()
                .setId(1L)
                .setAge(new BigDecimal(2))
                .setDate(LocalDate.now())
                .setName("TEST_PET")
                .setChippedEnumName(ChippedEnumName.NO)
                .setHourOfVisit(12)
                .setTypeOfAnimalEnumName(TypeOfAnimalEnumName.COW);
        petServiceModel.setTypeOfHelp(new TypeOfHelpServiceModel());

        when(modelMapper.map(petServiceModel, Pet.class)).thenReturn(new Pet());
        when(mockTypeOfHelpService.findByTypeOfHelpEnumName(any())).thenReturn(new TypeOfHelp());
        when(mockUserService.findUserByEmail(any())).thenReturn(new UserEntity());
        when(mockPetRepository.save(any())).thenReturn(new Pet());

        // Act
        petServiceTest.addPet(petServiceModel);

        // Assert
        // Verify that the pet was saved in the repository
        verify(mockPetRepository, times(1)).save(any());
    }

    @Test
    public void testCountAllPets() {
        // Arrange
        when(mockPetRepository.countAllPets()).thenReturn(10L);

        // Act
        Long count = petServiceTest.countAllPets();

        // Assert
        assertEquals(10L, count);
    }

    @Test
    public void testFindPetsByUsername() {
        // Arrange
        String email = "test@example.com";
        TypeOfHelpEnumName name = TypeOfHelpEnumName.HOTEL;
        Pet pet1 = new Pet();
        Pet pet2 = new Pet();
        when(mockPetRepository.findAllByOwner_EmailAndTypeOfHelp_TypeOfHelpEnumName(email, name))
                .thenReturn(Arrays.asList(pet1, pet2));
        when(modelMapper.map(pet1, PetViewModel.class)).thenReturn(new PetViewModel());
        when(modelMapper.map(pet2, PetViewModel.class)).thenReturn(new PetViewModel());

        // Act
        List<PetViewModel> petViewModels = petServiceTest.findPetsByUsername(email, name);

        // Assert
        assertEquals(2, petViewModels.size());
        verify(modelMapper, times(2)).map(any(), ArgumentMatchers.eq(PetViewModel.class));
    }

    @Test
    public void testFindPetsByOwner() {
        // Arrange
        String ownerEmail = "owner@example.com";
        Long expectedCount = 3L;

        when(mockPetRepository.findPetsByOwner(ownerEmail)).thenReturn(expectedCount);

        // Act
        Long actualCount = petServiceTest.findPetsByOwner(ownerEmail);

        // Assert
        assertEquals(expectedCount, actualCount);
        verify(mockPetRepository, times(1)).findPetsByOwner(ownerEmail);
    }

    @Test
    public void testRemove() {
        // Arrange
        Long petId = 1L;

        // Act
        petServiceTest.remove(petId);

        // Assert
        verify(mockPetRepository, times(1)).deleteById(petId);
    }

    @Test
    public void testFindPets() {
        // Arrange
        TypeOfHelpEnumName typeOfHelpEnumName = TypeOfHelpEnumName.HOTEL;

        Pet pet1 = new Pet(1L,"Pet1", new TypeOfHelp().setTypeOfHelpEnumName(typeOfHelpEnumName));
        Pet pet2 = new Pet(2L,"Pet2", new TypeOfHelp().setTypeOfHelpEnumName(typeOfHelpEnumName));



        when(mockPetRepository.findPetsByTypeOfHelp_TypeOfHelpEnumName(typeOfHelpEnumName)).thenReturn(Arrays.asList(pet1, pet2));
        PetViewModel petViewModel1 = new PetViewModel()
                .setId(1L)
                .setName("Pet1");

        PetViewModel petViewModel2 = new PetViewModel()
                .setId(2L)
                .setName("Pet2");

        when(modelMapper.map(pet1, PetViewModel.class)).thenReturn(petViewModel1);
        when(modelMapper.map(pet2, PetViewModel.class)).thenReturn(petViewModel2);

        // Act
        List<PetViewModel> result = petServiceTest.findPets(typeOfHelpEnumName);

        // Assert
        assertEquals(2, result.size());
        assertEquals(petViewModel1.getId(), result.get(0).getId());
        assertEquals(petViewModel1.getName(), result.get(0).getName());
        assertEquals(petViewModel2.getId(), result.get(1).getId());
        assertEquals(petViewModel2.getName(), result.get(1).getName());
    }

    }