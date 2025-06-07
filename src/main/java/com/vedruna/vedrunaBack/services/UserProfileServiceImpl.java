package com.vedruna.vedrunaBack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.vedruna.vedrunaBack.model.UserProfile;
import com.vedruna.vedrunaBack.repository.UserProfileRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Override
    public Optional<UserProfile> getByEmail(@PathVariable String email) {
        return userProfileRepository.findByEmail(email);
    }

    @Override
    public UserProfile createOrUpdateProfile(UserProfile userProfile) {
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
            return userProfileRepository.save(userProfile);
        }
    }

    @Override
    public List<UserProfile> getAllProfiles() {
        return userProfileRepository.findAll();
    }

    
}
