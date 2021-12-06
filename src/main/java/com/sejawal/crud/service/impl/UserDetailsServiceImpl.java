package com.sejawal.crud.service.impl;

import com.sejawal.crud.entity.um.MyUserDetails;
import com.sejawal.crud.entity.um.User;
import com.sejawal.crud.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(()->new UsernameNotFoundException("Username not found :"+username));
        UserDetails userDetails = user.map(MyUserDetails::new).get();
        System.out.println("userDetails = " + userDetails);
        return userDetails;
    }
}
