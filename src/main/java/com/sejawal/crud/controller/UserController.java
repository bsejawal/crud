package com.sejawal.crud.controller;

import com.sejawal.crud.model.Person;
import com.sejawal.crud.model.User;
import com.sejawal.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User add(){
        return userService.createUser();
    }
}
