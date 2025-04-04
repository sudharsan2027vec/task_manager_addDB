package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

     public int createUser(User user) {
        String name = user.getName();
        String username = user.getUsername();
        String password = user.getPassword();
        User newUser = new User(name,username,password);
        return (int)userRepository.save(newUser).getId();
     }
}