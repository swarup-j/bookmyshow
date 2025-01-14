package com.application.nextshow.controllers;

import com.application.nextshow.dtos.UserDTO;
import com.application.nextshow.dtos.VenueDTO;
import com.application.nextshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/api/v1/users")
    public List<UserDTO> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping(value = "/api/v1/user/{id}")
    public Optional<UserDTO> findUserById(@PathVariable(name = "id") UUID id){
        return userService.findUserById(id);
    }
    @PostMapping(value = "/api/v1/users")
    public List<UserDTO> saveAllUsers(@RequestBody List<UserDTO> userDTOList){
        return userService.saveAllUsers(userDTOList);
    }

    @PostMapping(value = "/api/v1/user")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }
    @DeleteMapping(value = "/api/v1/delete-user/{id}")
    public void deleteUserById(@PathVariable(name = "id") UUID id){
        userService.deleteUserById(id);
    }
}
