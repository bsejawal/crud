package com.sejawal.crud.controller;

import com.sejawal.crud.model.AuthenticationRequest;
import com.sejawal.crud.model.AuthenticationResponse;
import com.sejawal.crud.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;



    @GetMapping("/hello")
    public String home(){
        return "<h1>Welcome</h1>";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password ", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }

//    @GetMapping("/")
//    public String home(){
//        return "<h1>Welcome</h1>";
//    }
//    @GetMapping("/user")
//    public String user(){
//        return "<h1>Welcome User</h1>";
//    }
//    @GetMapping("/admin")
//    public String admin(){
//        return "<h1>Welcome Admin</h1>";
//    }
}
