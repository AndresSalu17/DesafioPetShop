package com.petshop.pet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.pet.models.PetModel;

public interface PetRepository extends JpaRepository<PetModel, Long> {

    List<PetModel> findByUserId(Long userId);
}
