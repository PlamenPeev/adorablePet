package com.example.adorablepet.service;

import com.example.adorablepet.models.dtos.UserRegistrationDTO;
import com.example.adorablepet.models.entities.UserEntity;
import com.example.adorablepet.models.enums.RoleEnumName;
import com.example.adorablepet.repository.RoleRepository;
import com.example.adorablepet.repository.UserRepository;
import com.example.adorablepet.session.CurrentUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final RoleRepository roleRepository;
    private final CurrentUser currentUser;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService, RoleRepository roleRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.roleRepository = roleRepository;
        this.currentUser = currentUser;
    }


    public void registerUser(UserRegistrationDTO userRegistrationDTO,
                             Consumer<Authentication> successfulLoginProcessor) {
        var userRole = roleRepository.
                findRoleByRoleEnumName(RoleEnumName.USER).orElseThrow();

        UserEntity userEntity = new UserEntity().
                setFirstName(userRegistrationDTO.getFirstName()).
                setLastName(userRegistrationDTO.getLastName()).
                setEmail(userRegistrationDTO.getEmail()).
                setPhoneNumber(userRegistrationDTO.getPhoneNumber()).
                setCountry(userRegistrationDTO.getCountry()).
                setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword())).
                setRoles(List.of(userRole));

        userRepository.save(userEntity);

        UserDetails userDetails = userDetailsService.loadUserByUsername(userRegistrationDTO.getEmail());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        successfulLoginProcessor.accept(authentication);
    }

    public UserEntity findUserByEmail(String email) {
        return this.userRepository
                .findUserByEmail(email)
                .orElse(null);
    }

    public UserEntity findUserById(Long id) {
        return this.userRepository
                .findUserById(id)
                .orElse(null);
    }

    public UserEntity loginUser(Long id, String mail) {
        currentUser.setId(id);
        currentUser.setEmail(mail);
        return loginUser(id,mail);
    }
}
