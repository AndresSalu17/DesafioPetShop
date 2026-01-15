package com.petshop.pet.DTOs;

public record UpdatePetDTO(
    String name,
    String type,
    String breed,
    Integer age
) {

}
