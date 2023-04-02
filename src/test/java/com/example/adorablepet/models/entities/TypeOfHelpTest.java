package com.example.adorablepet.models.entities;

import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TypeOfHelpTest {


    private TypeOfHelp mockTypeOfHelp;


    @BeforeEach
    void setUp() {
        mockTypeOfHelp = new TypeOfHelp();
        mockTypeOfHelp.setId(1L);
        mockTypeOfHelp.setTypeOfHelpEnumName(TypeOfHelpEnumName.SCHOOL);
        mockTypeOfHelp.setDescription("Provides school training for your pet.");
    }

    @Test
    public void testGettersAndSetters() {
        assertThat(mockTypeOfHelp.getId()).isEqualTo(1L);
        assertThat(mockTypeOfHelp.getTypeOfHelpEnumName()).isEqualTo(TypeOfHelpEnumName.SCHOOL);
        assertThat(mockTypeOfHelp.getDescription()).isEqualTo("Provides school training for your pet.");


        TypeOfHelpEnumName newType = TypeOfHelpEnumName.HOTEL;
        mockTypeOfHelp.setTypeOfHelpEnumName(newType);
        assertThat(mockTypeOfHelp.getTypeOfHelpEnumName()).isEqualTo(newType);

        String newDescription = "Provides hotels service to those in need.";
        mockTypeOfHelp.setDescription(newDescription);
        assertThat(mockTypeOfHelp.getDescription()).isEqualTo(newDescription);
    }
}
