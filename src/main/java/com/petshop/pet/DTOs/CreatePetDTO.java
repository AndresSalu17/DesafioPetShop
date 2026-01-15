package com.petshop.pet.DTOs;

public record CreatePetDTO(
    String name,
    String type,
    String breed,
    Integer age
) {

}
