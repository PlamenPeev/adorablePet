package com.example.adorablepet.repository;

import com.example.adorablepet.models.entities.Role;
import com.example.adorablepet.models.enums.RoleEnumName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class RoleRepositoryTest {

    @Mock
    private RoleRepository mockRoleRepository;

    @Test
    public void testFindRoleByRoleEnumName() {
        RoleEnumName roleEnumName = RoleEnumName.ADMIN;
        Role role = new Role();
        role.setRoleEnumName(roleEnumName);

        Mockito.when(mockRoleRepository.findRoleByRoleEnumName(roleEnumName))
                .thenReturn(Optional.of(role));

        Optional<Role> foundRole = mockRoleRepository.findRoleByRoleEnumName(roleEnumName);

        assertTrue(foundRole.isPresent());
        assertEquals(role, foundRole.get());
    }
}
