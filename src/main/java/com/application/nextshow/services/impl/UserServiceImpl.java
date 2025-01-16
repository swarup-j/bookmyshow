package com.application.nextshow.services.impl;

import com.application.nextshow.dtos.UserDTO;
import com.application.nextshow.entities.User;
import com.application.nextshow.mappers.UserMapper;
import com.application.nextshow.repositories.UserRepository;
import com.application.nextshow.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().
                map(userMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public Optional<UserDTO> findUserById(UUID id) {
         User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        UserDTO userDTO = userMapper.toDTO(user);
        return Optional.of(userDTO);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = userMapper.fromDTO(userDTO);
        userRepository.save(user);
        return userMapper.toDTO(user);
    }



    @Override
    public List<UserDTO> saveAllUsers(List<UserDTO> userDTOList ) {
        List<User> users = userDTOList.stream().map(userMapper::fromDTO).collect(Collectors.toList());
        userRepository.saveAll(users);
        return users.stream().map(userMapper::toDTO).collect(Collectors.toList());
    }
    @Override
    public void deleteUserById(UUID id){
        userRepository.deleteById(id);


    }



    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findByResetToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
