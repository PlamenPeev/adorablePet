package com.example.adorablepet.models.entities;

import com.example.adorablepet.models.enums.ChippedEnumName;
import com.example.adorablepet.models.enums.TypeOfAnimalEnumName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PetTest {

    @Mock
    private TypeOfHelp mockTypeOfHelp;

    @Mock
    private UserEntity mockOwner;

    @Test
    public void testGettersAndSetters() {
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("Fluffy");
        pet.setAge(2.5);
        pet.setChippedEnumName(ChippedEnumName.YES);
        pet.setTypeOfAnimalEnumName(TypeOfAnimalEnumName.CAT);
        pet.setTypeOfHelp(mockTypeOfHelp);
        pet.setOwner(mockOwner);
        LocalDate date = LocalDate.now();
        pet.setDate(date);
        pet.setHourOfVisit(15);

        assertEquals(1L, pet.getId());
        assertEquals("Fluffy", pet.getName());
        assertEquals(2.5, pet.getAge());
        assertEquals(ChippedEnumName.YES, pet.getChippedEnumName());
        assertEquals(TypeOfAnimalEnumName.CAT, pet.getTypeOfAnimalEnumName());
        assertEquals(mockTypeOfHelp, pet.getTypeOfHelp());
        assertEquals(mockOwner, pet.getOwner());
        assertEquals(date, pet.getDate());
        assertEquals(15, pet.getHourOfVisit());
    }
}
