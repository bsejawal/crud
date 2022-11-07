package com.bsejawal.crud.repository;

import com.bsejawal.crud.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
