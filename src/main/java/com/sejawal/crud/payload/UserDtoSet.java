package com.sejawal.crud.payload;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDtoSet {
    private Set<UserDto> userDtoSet = new HashSet<>();

}
