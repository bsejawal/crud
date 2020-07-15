package com.sejawal.crud.repository;

import com.sejawal.crud.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Optional<Person> findById(Long id);
    Optional<Person> findByName(String name);
}
