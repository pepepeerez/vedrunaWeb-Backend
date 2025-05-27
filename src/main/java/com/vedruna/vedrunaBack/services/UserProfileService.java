package com.vedruna.vedrunaBack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.vedruna.vedrunaBack.model.UserProfile;

public interface UserProfileService {

    Optional<UserProfile> getByEmail(@PathVariable String email);

    UserProfile createOrUpdateProfile(UserProfile userProfile);

    List<UserProfile> getAllProfiles();

    
}
