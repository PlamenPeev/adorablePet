package com.example.adorablepet.service;

import com.example.adorablepet.models.entities.UserEntity;
import com.example.adorablepet.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserEntity findUserByEmail(String email) {
        return this.userRepository
                .findUserByEmail(email)
                .orElse(null);
    }
}
