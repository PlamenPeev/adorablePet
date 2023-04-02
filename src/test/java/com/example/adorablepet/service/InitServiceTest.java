package com.example.adorablepet.service;

import com.example.adorablepet.models.entities.Role;
import com.example.adorablepet.models.enums.RoleEnumName;
import com.example.adorablepet.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InitServiceTest {

    @Mock
    private RoleRepository mockRoleRepository;

    @InjectMocks
    private InitService initService;

    @Test
    public void initRoles_shouldSaveRoles_whenNoRolesExist() {
        // Given
        when(mockRoleRepository.count()).thenReturn(0L);

        // When
        initService.initRoles();

        // Then
        ArgumentCaptor<Role> roleCaptor = ArgumentCaptor.forClass(Role.class);
        verify(mockRoleRepository, times(3)).save(roleCaptor.capture());
        List<Role> savedRoles = roleCaptor.getAllValues();
        assertThat(savedRoles).hasSize(3);
        assertThat(savedRoles).extracting(Role::getRoleEnumName).containsExactly(
                RoleEnumName.MODERATOR,
                RoleEnumName.ADMIN,
                RoleEnumName.USER);
    }

}
