package com.vedruna.vedrunaBack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vedruna.vedrunaBack.model.User;
import com.vedruna.vedrunaBack.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    // Crea o actualiza un usuario
    @Override
    public User createOrUpdate(String email, String name) {
        // Validar que el email sea institucional
        if (email == null || !email.endsWith("@a.vedrunasevillasj.es")) {
            throw new IllegalArgumentException("Solo se permite iniciar sesión con correos institucionales (@a.vedrunasevillasj.es)");
        }

        Optional<User> siExiste = userRepository.findByEmail(email);

        if (siExiste.isPresent()) {
            // Si el usuario ya existe, lo devolvemos
            return siExiste.get();
        } else {
            // Si no existe, lo creamos
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setName(name);
            return userRepository.save(newUser);
        }
    }

    
}
