package com.application.nextshow.mappers;

import com.application.nextshow.dtos.UserDTO;
import com.application.nextshow.entities.User;
import org.springframework.stereotype.Component;

@Component

public class UserMapper {
    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .address(user.getAddress())
                .email(user.getEmail())
                .phone(user.getPhone())
                .birthDate(user.getBirthDate())
                .role(user.getRole())
                .build();
    }

    public User fromDTO(UserDTO userDTO) {
        return User.builder()
                .firstname(userDTO.getFirstname())
                .lastname(userDTO.getLastname())
                .address(userDTO.getAddress())
                .email(userDTO.getEmail())
                .phone(userDTO.getPhone())
                .birthDate(userDTO.getBirthDate())
                .role(userDTO.getRole())
                .build();

    }
}