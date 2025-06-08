package com.vedruna.vedrunaBack.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.vedrunaBack.model.UserProfile;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
    
    // Buscar perfil por email
    Optional<UserProfile> findByEmail(String email);
}
