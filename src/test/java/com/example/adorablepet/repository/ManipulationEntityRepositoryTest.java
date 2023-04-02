package com.example.adorablepet.repository;

import com.example.adorablepet.models.entities.ManipulationEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ManipulationEntityRepositoryTest {


    @Mock
    private ManipulationEntityRepository mockManipulationEntityRepository;

    @Test
    public void testFindManipulationEntityByName() {
        String name = "test_Manipulation";
        ManipulationEntity manipulationEntity = new ManipulationEntity();
        manipulationEntity.setName(name);

        // Mock the behavior of the repository method
        when(mockManipulationEntityRepository.findManipulationEntityByName(name))
                .thenReturn(Optional.of(manipulationEntity));

        // Call the repository method
        Optional<ManipulationEntity> result = mockManipulationEntityRepository.findManipulationEntityByName(name);

        // Verify the result
        assertTrue(result.isPresent());
        assertEquals(name, result.get().getName());

        // Verify that the repository method was called exactly once with the correct argument
        verify(mockManipulationEntityRepository, times(1)).findManipulationEntityByName(name);
    }

}
