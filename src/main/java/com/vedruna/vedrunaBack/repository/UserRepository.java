package com.vedruna.vedrunaBack.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.vedrunaBack.model.User;

@Repository
public interface UserRepository  extends MongoRepository<User, String> {
    
    Optional<User> findByEmail(String email);
}
