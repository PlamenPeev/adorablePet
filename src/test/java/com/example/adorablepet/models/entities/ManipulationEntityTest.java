package com.example.adorablepet.models.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ManipulationEntityTest {

    @Mock
    private TypeOfManipulation mockTypeOfManipulation;

    @Test
    public void testSetName() {
        ManipulationEntity entity = new ManipulationEntity();
        entity.setName("name_Test");
        assertEquals("name_Test", entity.getName());
    }

    @Test
    public void testSetTypes() {
        ManipulationEntity entity = new ManipulationEntity();
        List<TypeOfManipulation> types = new ArrayList<>();
        types.add(mockTypeOfManipulation.setManipulation(new ManipulationEntity().setName("TREATMENT")));
        types.add(mockTypeOfManipulation.setManipulation(new ManipulationEntity().setName("EXAMINATION")));
        entity.setTypes(types);
        assertEquals(types, entity.getTypes());
    }
}
