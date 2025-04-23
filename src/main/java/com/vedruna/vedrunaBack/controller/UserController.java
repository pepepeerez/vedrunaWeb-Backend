package com.vedruna.vedrunaBack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.vedrunaBack.model.User;
import com.vedruna.vedrunaBack.services.UserService;
import com.vedruna.vedrunaBack.services.UserServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/vedruna/users")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserController {
    
    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{email}")
    public Optional<User> getByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    @PostMapping
    public User createOrUpdate(@RequestParam String email, @RequestParam String name) {
        return userService.createOrUpdate(email, name);
    }
}
