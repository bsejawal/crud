package com.sejawal.crud.repository;

import com.sejawal.crud.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {



}
