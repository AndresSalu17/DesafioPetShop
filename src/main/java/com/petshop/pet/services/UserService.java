package com.petshop.pet.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petshop.pet.models.UserModel;
import com.petshop.pet.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserModel saveUser(UserModel user) {
        
        if(userRepository.existsByPhone(user.getPhone())) {
            throw new RuntimeException("Phone number already in use");
        }
        
        if(user.getPhone() == null || user.getPhone().isEmpty()) {
            throw new RuntimeException("Phone number is required");
        }
        

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserModel updateUser(Long id, UserModel userDetails) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userDetails.getName());
        user.setPhone(userDetails.getPhone());

        return userRepository.save(user);
    }
}