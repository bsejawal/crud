package com.bsejawal.crud.controller;

import com.bsejawal.crud.model.User;
import com.bsejawal.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/register")
    public User add(@RequestBody User user){
        userRepository.save(user);
        return user;

    }
}
