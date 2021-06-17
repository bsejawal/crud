package com.sejawal.crud.service;

import com.sejawal.crud.model.User;
import com.sejawal.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser() {
        return userRepository.save(new User());
    }
}
