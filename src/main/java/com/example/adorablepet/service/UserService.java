package com.example.adorablepet.service;

import com.example.adorablepet.models.dtos.UserRegistrationDTO;
import com.example.adorablepet.models.entities.UserEntity;
import com.example.adorablepet.models.enums.RoleEnumName;
import com.example.adorablepet.models.views.UserViewModel;
import com.example.adorablepet.repository.RoleRepository;
import com.example.adorablepet.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       UserDetailsService userDetailsService, RoleRepository roleRepository,
                       ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
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



    public List<UserViewModel> findAllByPetsCount(String mail){
        return this.userRepository
                .findAllByPetsCount(mail)
                .stream()
                .map(user -> {
                    UserViewModel userViewModel= this.modelMapper
                            .map(user, UserViewModel.class);
                    return userViewModel;
                })
                .collect(Collectors.toList());
    }
}
