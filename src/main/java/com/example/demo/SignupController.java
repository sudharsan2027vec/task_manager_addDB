package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String registerUser(@RequestBody User user) {
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            return "Email is required!";
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            return "Email already exists!";
        }

        User savedUser = userRepository.save(user);
        return "User registered with ID: " + savedUser.getId();
    }
}
