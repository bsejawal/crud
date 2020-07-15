package com.sejawal.crud.service;

import com.sejawal.crud.model.Person;
import com.sejawal.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
}
