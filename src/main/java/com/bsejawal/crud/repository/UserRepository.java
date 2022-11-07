package com.bsejawal.crud.repository;


import com.bsejawal.crud.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

}