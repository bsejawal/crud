package com.bsejawal.crud.payload.vo;

import com.bsejawal.crud.payload.RoleRegistrationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleRegistrationDtoSet {
    private Set<RoleRegistrationDto> roleRegistrationDtoSet;

}
