package com.application.nextshow.controllers;

import com.application.nextshow.dtos.UserDTO;
import com.application.nextshow.dtos.VenueDTO;
import com.application.nextshow.entities.User;
import com.application.nextshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<UserDTO> findAllUsers(){
        return userService.findAllUsers();
    }
    @GetMapping("/{id}")
    public Optional<UserDTO> findUserById(@PathVariable(name = "id") UUID id){
        return userService.findUserById(id);
    }
    @PostMapping("/bulk")
    public List<UserDTO> saveAllUsers(@RequestBody List<UserDTO> userDTOList){
        return userService.saveAllUsers(userDTOList);
    }

    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable(name = "id") UUID id){
        userService.deleteUserById(id);
    }
//    @PostMapping(value = "/login")
//    public String login(@RequestBody User user){
//        return userService.verify(user);
//    }

}
