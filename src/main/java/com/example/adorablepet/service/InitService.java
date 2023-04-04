package com.example.adorablepet.service;

import com.example.adorablepet.models.entities.Role;
import com.example.adorablepet.models.entities.UserEntity;
import com.example.adorablepet.models.enums.RoleEnumName;
import com.example.adorablepet.repository.RoleRepository;
import com.example.adorablepet.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public InitService(RoleRepository roleRepository, UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       @Value("${app.default.password") String defaultPassword) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        initRoles();
        initUsers();
    }

    void initRoles() {
        if (roleRepository.count() == 0) {
            var moderatorRole = new Role().setRoleEnumName(RoleEnumName.MODERATOR);
            var adminRole = new Role().setRoleEnumName(RoleEnumName.ADMIN);
            var userRole = new Role().setRoleEnumName(RoleEnumName.USER);

            roleRepository.save(moderatorRole);
            roleRepository.save(adminRole);
            roleRepository.save(userRole);
        }
    }

    void initUsers() {
        if (userRepository.count() == 0) {
            initAdmin();
            initModerator();
            initNormalUser();
        }
    }

    private void initAdmin() {
        var adminUser = new UserEntity().
                setEmail("admin@adorable_pet.com").
                setFirstName("Admin").
                setLastName("Adminov").
                setPhoneNumber("0888234567").
                setCountry("Australia").
                setPassword(passwordEncoder.encode("petsecret")).
                setRoles(roleRepository.findAll());

        userRepository.save(adminUser);
    }


    private void initModerator() {

        var moderatorRole = roleRepository.
                findRoleByRoleEnumName(RoleEnumName.MODERATOR).orElseThrow();

        var moderatorUser = new UserEntity().
                setEmail("moderator@adorable_pet.com").
                setFirstName("Moderator").
                setLastName("Moderatorov").
                setPhoneNumber("0879234589").
                setCountry("Greece").
                setPassword(passwordEncoder.encode("petsecret")).
                setRoles(List.of(moderatorRole));

        userRepository.save(moderatorUser);

    }

    private void initNormalUser() {

        var userRole = roleRepository.
                findRoleByRoleEnumName(RoleEnumName.USER).orElseThrow();

        var normalUser = new UserEntity().
                setEmail("user@adorable_pet.com").
                setFirstName("User").
                setLastName("Userov").
                setPhoneNumber("0778234543").
                setCountry("France").
                setPassword(passwordEncoder.encode("petsecret")).
                setRoles(List.of(userRole));

        userRepository.save(normalUser);
    }
}
