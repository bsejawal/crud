package com.bsejawal.jpa.service;

import com.bsejawal.jpa.dto.PersonDto;
import com.bsejawal.jpa.entity.Person;
import com.bsejawal.jpa.repository.PersonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class PersonService {

    private final ObjectMapper objectMapper;
    private final PersonRepository personRepository;

    public PersonService(ObjectMapper objectMapper, PersonRepository personRepository) {
        this.objectMapper = objectMapper;
        this.personRepository = personRepository;
    }

   public boolean insert(PersonDto dto){
        int i = personRepository.insert(dto.getPersonId(), dto.getName(), dto.getEmail(), dto.getPhone(), dto.getGender(), dto.getDob());
        if(i > 0)
            return true;
        else return false;
    }

    public List<Person> get30DaysPersons(){
        Instant thirtyDaysAgo = Instant.now().minus(Duration.ofDays(30));
        return personRepository.findAllByCreatedAtAfter(thirtyDaysAgo);
    }

    private String writeValueAsString(Object o) {
        try{
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            System.err.println("Unable to write ValueASString for a Object "+o);
            return null;
        }
    }
}
