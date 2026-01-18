package com.petshop.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.pet.models.UserModel;


public interface UserRepository extends JpaRepository<UserModel, Long> {

    boolean existsByPhone(String phone);
}
