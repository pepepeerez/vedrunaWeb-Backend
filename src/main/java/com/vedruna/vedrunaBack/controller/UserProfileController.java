package com.vedruna.vedrunaBack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.vedruna.vedrunaBack.model.UserProfile;
import com.vedruna.vedrunaBack.services.UserProfileService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vedruna/user-profile")
@AllArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    /**
     * Obtiene un perfil de usuario a partir del email.
     *
     * @param email Email del usuario.
     * @return Perfil de usuario si existe.
     */
    @GetMapping("/{email}")
    public Optional<UserProfile> getProfileByEmail(@PathVariable String email) {
        return userProfileService.getByEmail(email);
    }

    /**
     * Crea o actualiza un perfil de usuario.
     *
     * @param userProfile Objeto con los datos del perfil.
     * @return Perfil guardado o actualizado.
     */
    @PostMapping
    public UserProfile createOrUpdateProfile(@RequestBody UserProfile userProfile) {
        return userProfileService.createOrUpdateProfile(userProfile);
    }

    /**
     * Obtiene todos los perfiles de usuarios registrados.
     *
     * @return Lista de todos los perfiles de usuario.
     */
    @GetMapping("/all")
    public List<UserProfile> getAllProfiles() {
        return userProfileService.getAllProfiles();
    }
}
