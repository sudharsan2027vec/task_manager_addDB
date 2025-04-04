package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/signInUp")
    public String signInUp() {
        return "signInUp.html";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        userRepository.save(user);
        System.out.println("User registered: " + user);
        return "redirect:/signInUp"; // Redirect to login page after registration
    }

    @GetMapping("/task")
    public String task() {
        return "task.html";
    }
}
