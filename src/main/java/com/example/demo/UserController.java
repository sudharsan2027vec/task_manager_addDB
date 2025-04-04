package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Integer> createUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
    @PostMapping("/register")
    public ResponseEntity<Integer> registerUser(@Valid @RequestBody SignUpRequest signUpRequest){
      User newUser = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getPassword());
      return new ResponseEntity<>(userService.createUser(newUser), HttpStatus.CREATED);
    }
  
}
