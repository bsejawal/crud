package com.sejawal.crud.service;

import com.sejawal.crud.model.User;
import com.sejawal.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName); // get the User from database
        user.orElseThrow(()-> new UsernameNotFoundException("User not found : "+ userName)); // this line will throw UsernameNotFoundException if the user is not exists
        return user.map(MyUserDetails::new).get(); // map User to MyUserDetails object
    }
}
