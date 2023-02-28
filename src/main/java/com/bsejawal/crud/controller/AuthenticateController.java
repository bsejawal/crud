package com.bsejawal.crud.controller;

import com.bsejawal.crud.payload.vo.AuthRequest;
import com.bsejawal.crud.payload.vo.AuthResponse;
import com.bsejawal.crud.service.CustomUserDetailsService;
import com.bsejawal.crud.util.JwtUtil;
import com.bsejawal.crud.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateController {
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService userDetailsService;


    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            System.out.println("######## authenticated successfully ");
        }catch (Exception e){
            System.out.println("error "+ e.getMessage());
            throw new Exception("Invalid username/password");
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authRequest.getUsername());
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwtUtil.generateToken(userDetails));
        authResponse.setRoles(userDetails.getAuthorities().toString());
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }


    @PostMapping("/refreshToken")
    public ResponseEntity<AuthResponse> refreshToken (@RequestBody String jwt) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtUtil.extractUsername(jwt));
       if(!StringUtil.isEmpty(jwt) && jwtUtil.validateToken(jwt, userDetails)){

           //TODO refresh token

           AuthResponse authResponse = new AuthResponse();
           authResponse.setJwt(jwt);
           authResponse.setRoles(userDetails.getAuthorities().toString());
           return new ResponseEntity<>(authResponse, HttpStatus.OK);
       }
       return (ResponseEntity<AuthResponse>) ResponseEntity.status(HttpStatus.UNAUTHORIZED);

    }

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/authenticate")
    public String authenticate(){
        return "authenticate get";
    }
    @GetMapping("/user")
    public String user(){
        return "Welcome User";
    }
    @GetMapping("/admin")
    public String admin(){
        return "Welcome Admin";
    }

}
