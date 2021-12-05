package com.sejawal.crud.service;


import com.sejawal.crud.payload.UserDto;

public interface UserService {
    UserDto createRole(UserDto roleDto);
    UserDto loadByUsername(String username);
    UserDto loadByUsernameOrEmail(String username, String email);
    UserDto loadByEmail(String email);

}
