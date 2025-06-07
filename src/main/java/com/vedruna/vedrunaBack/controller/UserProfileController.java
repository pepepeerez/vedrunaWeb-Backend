package com.vedruna.vedrunaBack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;  // Import añadido
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.vedrunaBack.model.UserProfile;
import com.vedruna.vedrunaBack.services.UserProfileService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vedruna/user-profile")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping("/{email}")
    public Optional<UserProfile> getProfileByEmail(@PathVariable String email) {
        return userProfileService.getByEmail(email);
    }

    @PostMapping
    public UserProfile createOrUpdateProfile(@RequestBody UserProfile userProfile) {
        return userProfileService.createOrUpdateProfile(userProfile);
    }

    @GetMapping("/all")
    public List<UserProfile> getAllProfiles() {
        return userProfileService.getAllProfiles();
    }

}
