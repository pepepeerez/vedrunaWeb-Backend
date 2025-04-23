package com.vedruna.vedrunaBack.services;

import java.util.List;
import java.util.Optional;

import com.vedruna.vedrunaBack.model.User;

public interface UserService {
    
    List<User> getAllUsers();  // Devuelve todos los usuarios
    Optional<User> getByEmail(String email);  // Devuelve un usuario por su email
    User createOrUpdate(String email, String name);  // Crea o actualiza un usuario
   
}
