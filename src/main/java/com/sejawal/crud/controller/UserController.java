package com.sejawal.crud.controller;

import com.sejawal.crud.model.User;
import com.sejawal.crud.repository.UserRepository;
import com.sejawal.crud.service.UserService;
import com.sejawal.crud.utils.LoginValidation;
import com.sejawal.crud.vo.LoginRequest;
import com.sejawal.crud.vo.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService personService;

    private final UserRepository userRepository;

    UserController( UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest){
        System.out.println("loginRequest = " + loginRequest);
        LoginResponse loginResponse =  new LoginResponse();
        if(LoginValidation.isUserNameAndPasswordValid(loginRequest)) {
            User user = userRepository.findByUsername(loginRequest.getUsername()).orElse(null);
            if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
                loginResponse.setLoggedIn(true);
                loginResponse.setUsername(user.getUsername());
                System.out.println("Login Success");
                return ResponseEntity.ok(loginResponse);
            }

        }
        System.out.println("Login Failed");
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("User:"+loginRequest.getUsername() +" Not Found OR username/password not matched");
    }



    @RequestMapping(value = "/test")
    public String test(){
        return "test Working!! ";
    }
}
