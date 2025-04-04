package com.example.demo;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Optional: You can inspect the status code here if needed
        return "error"; // maps to error.html in templates
    }

    // This is not required in Spring Boot 2.3+, but still safe to add
    public String getErrorPath() {
        return "/error";
    }
}
