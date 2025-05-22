package com.vedruna.vedrunaBack.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vedruna.vedrunaBack.model.UserProfile;
import com.vedruna.vedrunaBack.repository.UserProfileRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Override
    public Optional<UserProfile> getByEmail(String email) {
        return userProfileRepository.findByEmail(email);
    }

    @Override
    public UserProfile createOrUpdateProfile(UserProfile userProfile) {
        // Buscar perfil existente
        Optional<UserProfile> existingProfile = userProfileRepository.findByEmail(userProfile.getEmail());

        if (existingProfile.isPresent()) {
            UserProfile perfil = existingProfile.get();
            perfil.setCiclo(userProfile.getCiclo());
            perfil.setCurso(userProfile.getCurso());
            perfil.setDescripcion(userProfile.getDescripcion());
            perfil.setGithubLink(userProfile.getGithubLink());
            perfil.setLinkedinLink(userProfile.getLinkedinLink());
            return userProfileRepository.save(perfil);
        } else {
            // Nuevo perfil
            return userProfileRepository.save(userProfile);
        }
    }
}
