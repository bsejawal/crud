//package com.bsejawal.crud.service;
//
//import com.bsejawal.crud.model.Role;
//import com.bsejawal.crud.model.User;
//import com.bsejawal.crud.repository.UserRepository;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//    private UserRepository userRepository;
//
//    public CustomUserDetailsService(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: "+ username));
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),myRolesToAuthorities(user.getRoles()));
//    }
//
//    private Collection<? extends GrantedAuthority> myRolesToAuthorities(Set<Role> roles){
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }
//}
