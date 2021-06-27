package com.sejawal.crud.service;

import com.sejawal.crud.exception.MyUsernameNotFoundException;
import com.sejawal.crud.model.User;
import com.sejawal.crud.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserDetailsService //implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public MyUserDetails loadUserByUsername(String userName) throws MyUsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName); // get the User from database
        user.orElseThrow(()-> new MyUsernameNotFoundException("User not found : "+ userName)); // this line will throw UsernameNotFoundException if the user is not exists
        return user.map(MyUserDetails::new).get(); // map User to MyUserDetails object
    }
}


/*
package com.sejawal.crud.service;

import com.sejawal.crud.model.User;
import com.sejawal.crud.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName); // get the User from database
        user.orElseThrow(()-> new UsernameNotFoundException("User not found : "+ userName)); // this line will throw UsernameNotFoundException if the user is not exists
        return user.map(MyUserDetails::new).get(); // map User to MyUserDetails object
    }
}
*/
