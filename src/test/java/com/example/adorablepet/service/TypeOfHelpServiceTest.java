package com.example.adorablepet.service;

import com.example.adorablepet.models.entities.TypeOfHelp;
import com.example.adorablepet.models.enums.TypeOfHelpEnumName;
import com.example.adorablepet.repository.TypeOfHelpRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TypeOfHelpServiceTest {
    @Mock
    private TypeOfHelpRepository typeOfHelpRepository;

    @InjectMocks
    private TypeOfHelpService typeOfHelpService;

    @Test
    public void testInitTypeOfHelps() {
        when(typeOfHelpRepository.count()).thenReturn(0L);

        typeOfHelpService.initTypeOfHelps();

        verify(typeOfHelpRepository, times(TypeOfHelpEnumName
                .values().length)).save(any(TypeOfHelp.class));
    }

    @Test
    public void testFindByTypeOfHelpEnumName() {
        TypeOfHelpEnumName typeOfHelpEnumName = TypeOfHelpEnumName.TREATMENT;
        TypeOfHelp typeOfHelp = new TypeOfHelp();
        typeOfHelp.setTypeOfHelpEnumName(typeOfHelpEnumName);
        when(typeOfHelpRepository.findByTypeOfHelpEnumName(typeOfHelpEnumName))
                .thenReturn(Optional.of(typeOfHelp));

        TypeOfHelp result = typeOfHelpService
                .findByTypeOfHelpEnumName(typeOfHelpEnumName);

        assertEquals(typeOfHelp, result);
    }
}
