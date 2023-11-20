package com.example.petproject.repositorys;

import com.example.petproject.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRep extends JpaRepository<UserModel, Long> {

    UserModel findByUsername(String username);
}
