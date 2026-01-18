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

import com.petshop.pet.DTOs.CreatePetDTO;
import com.petshop.pet.DTOs.UpdatePetDTO;
import com.petshop.pet.models.PetModel;
import com.petshop.pet.services.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/user/pets/{userId}")
    public List<PetModel> getAllPetsByUser(@PathVariable Long userId) {
        return petService.getAllPetsByUser(userId);
    }

    @PostMapping("/user/{userId}")
    public PetModel createPet(@PathVariable Long userId, @RequestBody CreatePetDTO createPetDTO) {
        PetModel pet = new PetModel();
        pet.setName(createPetDTO.name());
        pet.setType(createPetDTO.type());
        pet.setBreed(createPetDTO.breed());
        pet.setAge(createPetDTO.age());
        return petService.savePet(userId, pet);
    }

    @PutMapping("/{id}")
    public PetModel updatePet(@PathVariable Long id, @RequestBody UpdatePetDTO updatePetDTO) {
        PetModel pet = new PetModel();
        pet.setName(updatePetDTO.name());
        pet.setType(updatePetDTO.type());
        pet.setBreed(updatePetDTO.breed());
        pet.setAge(updatePetDTO.age());
        return petService.updatePet(id, pet);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.deletePet(id);
    }
}