package com.bsejawal.crud.payload.vo;

import com.bsejawal.crud.payload.UserRegistrationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDtoSet {
    private Set<UserRegistrationDto> userRegistrationDtoSet;

}
