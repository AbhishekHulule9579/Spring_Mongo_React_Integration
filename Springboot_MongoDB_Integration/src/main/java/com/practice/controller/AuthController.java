package com.practice.controller;

import com.practice.model.User;
import com.practice.repository.UserRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        user.setRole("Teacher");
        userRepository.save(user);
        return  "user register successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        User existing=userRepository.findByUsername(user.getUsername())
        .orElseThrow(()->new RuntimeException("User not found"));

        if(!existing.getPassword().equals(user.getPassword())){
            throw new RuntimeException("Invalid Password");
        }
        return "Login Successfull";
    }
}
