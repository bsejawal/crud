package com.sejawal.crud.service;


import com.sejawal.crud.entity.um.Role;
import com.sejawal.crud.payload.RoleDto;

public interface RoleService {
    RoleDto createRole(RoleDto roleDto);
    Role loadRoleByName(String name);
    RoleDto getDtoByName(String name);

}
