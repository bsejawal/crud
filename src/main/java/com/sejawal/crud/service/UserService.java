package com.sejawal.crud.service;

import com.sejawal.crud.model.User;
import com.sejawal.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public User findByUserName(String userName)  {
        User user = userRepository.findByUserName(userName); // get the User from database

       return user;
    }
    public List<User> findAll(){
        List<User> users = userRepository.findAll();
        return users;
    }
}

