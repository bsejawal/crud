package com.sejawal.crud.controller;

import com.sejawal.crud.payload.AuthenticateResponse;
import com.sejawal.crud.payload.AuthenticationRequest;
import com.sejawal.crud.utils.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;


@RestController

public class AuthenticateController {
    private AuthenticationManager authenticationManager;

    private JwtUtil jwtUtil;

    private UserDetailsService userDetailsService;

    public AuthenticateController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticateResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        System.out.println("future Time -> "+ new Date(System.currentTimeMillis()+ (10000 * 60 * 60 * 10)));
        System.out.println("Current Time -> "+ new Date( System.currentTimeMillis()));

        System.out.println("authenticationRequest = " + authenticationRequest);
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }catch(BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticateResponse(jwt));
    }
}
