package com.example.adorablepet.service;

import com.example.adorablepet.AdorablePetApplication;
import com.example.adorablepet.models.entities.Role;
import com.example.adorablepet.models.entities.UserEntity;
import com.example.adorablepet.models.enums.RoleEnumName;
import com.example.adorablepet.models.user.AdorablePetUserDetails;
import com.example.adorablepet.repository.UserRepository;
import jakarta.persistence.Column;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationUserDetailsServiceTest {


    @Mock
private UserRepository mockUserRepo;

    private ApplicationUserDetailsService toTest;

    @BeforeEach
void setUp(){
        toTest = new ApplicationUserDetailsService(
                mockUserRepo
        );
    }


    @Test
    void testLoadUserByUsername_UserExists(){

        // arrange
        UserEntity testUserEntity = new UserEntity()
                .setEmail("test@firstTest.com")
                .setPassword("vetClinic")
                .setFirstName("Paun")
                .setLastName("{Paunov")
                .setPhoneNumber("12345678")
                .setRoles(
                     List.of(
                             new Role().setRoleEnumName(RoleEnumName.ADMIN),
                             new Role().setRoleEnumName(RoleEnumName.USER),
                             new Role().setRoleEnumName(RoleEnumName.MODERATOR)
                     )
                );
                   when(mockUserRepo.findUserByEmail(testUserEntity.getEmail()))
                           .thenReturn(Optional.of(testUserEntity));

        //act
        AdorablePetUserDetails userDetails =(AdorablePetUserDetails)
            toTest.loadUserByUsername(testUserEntity.getEmail());

        //assert
        Assertions.assertEquals(testUserEntity.getEmail(), userDetails.getUsername());
        Assertions.assertEquals(testUserEntity.getFirstName(), userDetails.getFirstName());
        Assertions.assertEquals(testUserEntity.getLastName(), userDetails.getLastName());
        Assertions.assertEquals(testUserEntity.getPassword(), userDetails.getPassword());
        Assertions.assertEquals(testUserEntity.getFirstName() + " " + testUserEntity.getLastName(),
                userDetails.getFullName());

        var authorities = userDetails.getAuthorities();

        Assertions.assertEquals(3, authorities.size());

        var authoritiesIter = authorities.iterator();

        Assertions.assertEquals("ROLE_" + RoleEnumName.ADMIN.name(),
                authoritiesIter.next().getAuthority());
        Assertions.assertEquals("ROLE_" + RoleEnumName.USER.name(),
                authoritiesIter.next().getAuthority());
        Assertions.assertEquals("ROLE_" + RoleEnumName.MODERATOR.name(),
                authoritiesIter.next().getAuthority());
    }



    @Test
    void testLoadUserByUsername_UserDoesNotExists(){
        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> toTest.loadUserByUsername("faulse@test.com")
        );
    }
}
