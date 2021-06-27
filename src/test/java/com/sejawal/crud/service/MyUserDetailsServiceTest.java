/*
package com.sejawal.crud.service;

import com.sejawal.crud.model.User;
import com.sejawal.crud.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class MyUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository; // = Mockito.mock(UserRepository.class);

    @Test
    @DisplayName("find the valid user")
    public void testLoadUserByUsername(){
        UserDetailsService userDetailsService = new MyUserDetailsService(userRepository);
        User user = new User("foo", "foo", true, "ROLE_USER");
        Mockito.when(userRepository.findByUserName("foo")).thenReturn(Optional.of(user));
        UserDetails userDetails = userDetailsService.loadUserByUsername("foo");
        Assertions.assertEquals("foo", userDetails.getUsername());
    }

}*/
