package com.vedruna.vedrunaBack.services;

import java.util.List;
import java.util.Optional;

import com.vedruna.vedrunaBack.model.UserProfile;

public interface UserProfileService {

    /**
     * Obtiene un perfil de usuario por su email.
     *
     * @param email Email del usuario.
     * @return Perfil encontrado (si existe).
     */
    Optional<UserProfile> getByEmail(String email);

    /**
     * Crea o actualiza un perfil de usuario.
     *
     * @param userProfile Objeto con los datos del perfil.
     * @return Perfil creado o actualizado.
     */
    UserProfile createOrUpdateProfile(UserProfile userProfile);

    /**
     * Devuelve todos los perfiles de usuario existentes.
     *
     * @return Lista de perfiles.
     */
    List<UserProfile> getAllProfiles();
}
