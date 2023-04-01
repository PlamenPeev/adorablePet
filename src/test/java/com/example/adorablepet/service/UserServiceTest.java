package com.example.adorablepet.service;

import com.example.adorablepet.models.dtos.UserRegistrationDTO;
import com.example.adorablepet.models.entities.Role;
import com.example.adorablepet.models.entities.UserEntity;
import com.example.adorablepet.models.enums.RoleEnumName;
import com.example.adorablepet.models.user.AdorablePetUserDetails;
import com.example.adorablepet.repository.RoleRepository;
import com.example.adorablepet.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private UserDetailsService mockUserDetailsService;
    @Mock
    private RoleRepository mockRoleRepository;

    @Mock
    private ModelMapper modelMapper;


    private UserService userServiceTest;

    @BeforeEach
    void setUp() {
        userServiceTest = new UserService(mockUserRepository,passwordEncoder,
                mockUserDetailsService, mockRoleRepository, modelMapper);


    }

    @Test
    public void testRegisterUser() {
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        userRegistrationDTO.setEmail("test@test.com");
        userRegistrationDTO.setFirstName("FirstTest");
        userRegistrationDTO.setLastName("Testovich");
        userRegistrationDTO.setPhoneNumber("12345678");
        userRegistrationDTO.setCountry("Germany");
        userRegistrationDTO.setPassword("password123123");
        userRegistrationDTO.setConfirmPassword("password123123");

        Role userRole = new Role()
                .setRoleEnumName(RoleEnumName.USER);
        when(mockRoleRepository.findRoleByRoleEnumName(RoleEnumName.USER))
                .thenReturn(Optional.of(userRole));

        UserEntity testUser = new UserEntity()
                .setFirstName(userRegistrationDTO.getFirstName())
                .setLastName(userRegistrationDTO.getLastName())
                .setEmail(userRegistrationDTO.getEmail())
                .setPhoneNumber(userRegistrationDTO.getPhoneNumber())
                .setCountry(userRegistrationDTO.getCountry())
                .setPassword("encodedPassword")
                .setRoles(List.of(userRole));

        when(mockUserRepository.save(any(UserEntity.class))).thenReturn(testUser);


        AdorablePetUserDetails userDetails = new AdorablePetUserDetails(
                1L, "12345", "johny","John", "Doe",
                "087654321","Bulgaria", Collections.emptyList());

        when(mockUserDetailsService.loadUserByUsername(userRegistrationDTO
                .getEmail())).thenReturn(userDetails);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        Consumer<Authentication> successfulLoginProcessor = mock(Consumer.class);

        userServiceTest.registerUser(userRegistrationDTO, successfulLoginProcessor);

        verify(mockRoleRepository).findRoleByRoleEnumName(RoleEnumName.USER);
        verify(mockUserRepository).save(any(UserEntity.class));
        verify(mockUserDetailsService).loadUserByUsername(userRegistrationDTO.getEmail());
        verify(successfulLoginProcessor).accept(authentication);
    }

    @Test
    public void testFindUserByEmail() {
        String email = "test@example.com";
        UserEntity userEntity = new UserEntity().setEmail(email);
        when(mockUserRepository.findUserByEmail(email)).thenReturn(Optional.of(userEntity));

        UserEntity foundUser = userServiceTest.findUserByEmail(email);

        verify(mockUserRepository).findUserByEmail(email);
        assertEquals(userEntity, foundUser);
    }
}
