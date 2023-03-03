package com.bsejawal.crud.controller;

import com.bsejawal.crud.model.User;
import com.bsejawal.crud.payload.UserRegistrationDto;
import com.bsejawal.crud.repository.RoleRepository;
import com.bsejawal.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;


    @PostMapping(value = "/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDto userDto){
        System.out.println("userDto = " + userDto);
        // check if username is already exists

        if(userRepository.existsByUsername(userDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.CONFLICT);
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setRoles(Set.of(roleRepository.findByName("ROLE_USER")));
        user.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

//    @GetMapping("/user")
//    public String user(){
//        return "welcome to user";
//    }
}
