package com.petshop.pet.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petshop.pet.models.PetModel;
import com.petshop.pet.models.UserModel;
import com.petshop.pet.repositories.PetRepository;
import com.petshop.pet.repositories.UserRepository;

@Service
public class PetService {

    private PetRepository petRepository;
    private UserRepository userRepository;

    public PetService(PetRepository petRepository, UserRepository userRepository) {
        this.petRepository = petRepository;
        this.userRepository = userRepository;
    }

    public List<PetModel> getAllPetsByUser(Long userId) {
        return petRepository.findByUserId(userId);
    }

    public PetModel savePet(Long userId, PetModel pet) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        pet.setUser(user);
        return petRepository.save(pet);
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    public PetModel updatePet(Long id, PetModel petDetails) {
        PetModel pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found"));

        pet.setName(petDetails.getName());
        pet.setType(petDetails.getType());
        pet.setBreed(petDetails.getBreed());
        pet.setAge(petDetails.getAge());

        return petRepository.save(pet);
    }

}
