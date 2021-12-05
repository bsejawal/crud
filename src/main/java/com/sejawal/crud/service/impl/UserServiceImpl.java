package com.sejawal.crud.service.impl;

import com.sejawal.crud.entity.um.User;
import com.sejawal.crud.payload.UserDto;
import com.sejawal.crud.repository.UserRepository;
import com.sejawal.crud.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    final private ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public UserDto createRole(UserDto userDto) {
        User user = mapToEntity(userDto);
        User newUser = userRepository.save(user);
        return mapToDto(newUser);
    }

    @Override
    public UserDto loadByUsername(String username) {
        return null;
    }

    @Override
    public UserDto loadByUsernameOrEmail(String username, String email) {
        return null;
    }

    @Override
    public UserDto loadByEmail(String email) {
        return null;
    }

    private UserDto mapToDto(User user) {
        return mapper.map(user, UserDto.class);
    }

    private User mapToEntity(UserDto userDto) {
        return mapper.map(userDto, User.class);
    }
}
