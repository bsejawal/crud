package com.bsejawal.crud.controller;

import com.bsejawal.crud.model.User;
import com.bsejawal.crud.payload.UserRegistrationDto;
import com.bsejawal.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDto userDto){
        System.out.println("userDto = " + userDto);
        // check if username is already exists

        if(userRepository.existsByUsername(userDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.CONFLICT);
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}
