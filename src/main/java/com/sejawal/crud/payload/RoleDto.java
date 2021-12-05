package com.sejawal.crud.payload;

import lombok.Data;

import java.util.Set;

@Data
public class RoleDto {
    private long id;
    private String name;
    Set<UserDto> users;
}
