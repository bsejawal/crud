package com.sejawal.crud.controller;

import com.sejawal.crud.model.User;
import com.sejawal.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping( "/user")
    public ResponseEntity<User> user(@RequestParam(name="name", defaultValue = "foo") String name) throws Exception{

    return ResponseEntity.ok(userService.findByUserName(name));

    }
    @GetMapping("/users")
    public List<User> users() throws Exception{

        return userService.findAll();

    }
}
