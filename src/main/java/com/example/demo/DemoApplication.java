package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@SpringBootApplication
@Controller
public class DemoApplication {

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/signInUp")
    public String signInUp() {
        return "signInUp.html";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute SignInRequest signinPage) {
        System.out.println(signinPage.toString());
        return "signInUp.html";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute SignUpRequest signupPage) {
        System.out.println(signupPage.toString());
        return "signInUp.html";
    }

    @GetMapping("/task")
    public String task() {
        return "task.html";
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}