package com.application.nextshow.services;

import com.application.nextshow.dtos.UserDTO;
import com.application.nextshow.dtos.UserDTO;
import com.application.nextshow.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface UserService {

    List<UserDTO> findAllUsers();
    Optional<UserDTO> findUserById(UUID id);
    List<UserDTO> saveAllUsers(List<UserDTO> userDTOList);
    UserDTO saveUser(UserDTO userDTO);
    void deleteUserById(UUID id);


    boolean existsByEmail(String email);
    void saveUser(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findByResetToken(String token);
    void updateUser(User user);
}
