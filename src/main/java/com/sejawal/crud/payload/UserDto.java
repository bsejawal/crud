package com.sejawal.crud.payload;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto {
    private String email;

    private String username;

    private String password;

    private boolean active;

    private Set<RoleDto> roles = new HashSet<>();
}
