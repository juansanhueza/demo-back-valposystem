package com.example.demovalposystem.repositories;

// import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demovalposystem.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract Optional<UserModel> findById(Long id);
    
}
