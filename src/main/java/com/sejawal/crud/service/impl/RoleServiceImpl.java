package com.sejawal.crud.service.impl;

import com.sejawal.crud.entity.um.Role;
import com.sejawal.crud.exception.ResourceNotFoundException;
import com.sejawal.crud.payload.RoleDto;
import com.sejawal.crud.repository.RoleRepository;
import com.sejawal.crud.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    final private RoleRepository roleRepository;
    final private ModelMapper mapper;


    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper mapper) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role role = mapToEntity(roleDto);
        Role newRole = roleRepository.save(role);
        return mapToDto(newRole);
    }

    @Override
    public Role loadRoleByName(String name) {
        Role role = roleRepository.findByName(name).orElseThrow(()-> new ResourceNotFoundException("Role", "name", name));
        return role;
    }
    public RoleDto getDtoByName(String name) {
        return mapToDto(loadRoleByName(name));
    }

    private RoleDto mapToDto(Role role) {
        return mapper.map(role, RoleDto.class);
    }

    private Role mapToEntity(RoleDto roleDto) {
        return mapper.map(roleDto, Role.class);
    }
}
