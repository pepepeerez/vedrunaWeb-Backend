package com.vedruna.vedrunaBack.services;

import java.util.Optional;

import com.vedruna.vedrunaBack.model.UserProfile;

public interface UserProfileService {

    Optional<UserProfile> getByEmail(String email);

    UserProfile createOrUpdateProfile(UserProfile userProfile);
}
