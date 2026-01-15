package com.petshop.pet.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.pet.DTOs.CreateUserDTO;
import com.petshop.pet.DTOs.UpdateUserDTO;
import com.petshop.pet.models.UserModel;
import com.petshop.pet.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserModel createUser(@RequestBody CreateUserDTO createUserDTO) {
        UserModel user = new UserModel();
        user.setName(createUserDTO.name());
        user.setPhone(createUserDTO.phone());
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UpdateUserDTO updateUserDTO) {
        UserModel user = userService.findById(id);
        user.setName(updateUserDTO.name());
        user.setPhone(updateUserDTO.phone());
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
