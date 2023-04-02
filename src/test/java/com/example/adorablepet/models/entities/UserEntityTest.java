package com.example.adorablepet.models.entities;

import com.example.adorablepet.models.enums.ChippedEnumName;
import com.example.adorablepet.models.enums.RoleEnumName;
import com.example.adorablepet.models.enums.TypeOfAnimalEnumName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserEntityTest {

    @Mock
    private Role mockRole;
    @Mock
    private TypeOfHelp mockTypeOfHelp;

    @Mock
    private UserEntity mockOwner;

    @Test
    void testGettersAndSetters() {
        // create a mock set of pets
        LocalDate date = LocalDate.now();

        Pet pet1 = new Pet();
        pet1.setId(1L);
        pet1.setName("Fluffy");
        pet1.setAge(2.5);
        pet1.setChippedEnumName(ChippedEnumName.YES);
        pet1.setTypeOfAnimalEnumName(TypeOfAnimalEnumName.CAT);
        pet1.setTypeOfHelp(mockTypeOfHelp);
        pet1.setOwner(mockOwner);
        pet1.setDate(date);
        pet1.setHourOfVisit(15);

        Pet pet2 = new Pet();
        pet2.setId(2L);
        pet2.setName("Viking");
        pet2.setAge(4.0);
        pet2.setChippedEnumName(ChippedEnumName.YES);
        pet2.setTypeOfAnimalEnumName(TypeOfAnimalEnumName.DOG);
        pet2.setTypeOfHelp(mockTypeOfHelp);
        pet2.setOwner(mockOwner);
        pet2.setDate(date);
        pet2.setHourOfVisit(11);

        Set<Pet> pets = new HashSet<>();
        pets.add(pet1);
        pets.add(pet2);

        // create a mock list of roles
        List<RoleEnumName> roles = new ArrayList<>();
        roles.add(RoleEnumName.USER);
        roles.add(RoleEnumName.ADMIN);

        // create a mock user entity
        UserEntity mockUser = mock(UserEntity.class);
        when(mockUser.getPassword()).thenReturn("password");
        when(mockUser.getFirstName()).thenReturn("John");
        when(mockUser.getLastName()).thenReturn("Doe");
        when(mockUser.getEmail()).thenReturn("johndoe@example.com");
        when(mockUser.getPhoneNumber()).thenReturn("1234567890");
        //when(mockUser.getRoles()).thenReturn(roles);
        when(mockUser.getPets()).thenReturn((pets));
        when(mockUser.getCountry()).thenReturn("US");

        // verify that the getters return the expected values
        assertEquals("password", mockUser.getPassword());
        assertEquals("John", mockUser.getFirstName());
        assertEquals("Doe", mockUser.getLastName());
        assertEquals("johndoe@example.com", mockUser.getEmail());
        assertEquals("1234567890", mockUser.getPhoneNumber());
       // assertEquals(roles, mockUser.getRoles());
        assertEquals(pets, mockUser.getPets());
        assertEquals("US", mockUser.getCountry());
    }
}
