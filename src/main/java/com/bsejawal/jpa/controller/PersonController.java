package com.bsejawal.jpa.controller;

import com.bsejawal.jpa.dto.PersonDto;
import com.bsejawal.jpa.entity.Person;
import com.bsejawal.jpa.repository.PersonRepository;
import com.bsejawal.jpa.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@RestController
public class PersonController {
    PersonRepository personRepository;

    PersonService personService;

    PersonController(PersonRepository personRepository, PersonService personService){
        this.personRepository = personRepository;
        this.personService = personService;
    }

    @GetMapping("/test")
    public String test(){
        return "test123456";
    }

    @PostMapping(path = "/person")
    public ResponseEntity<Person> save(@RequestBody @Valid PersonDto personDto){
        return new ResponseEntity<>(personRepository.save(personDto.mapToPerson()), HttpStatus.CREATED);
    }

    @GetMapping("/persons")
    public ResponseEntity getAll(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(personRepository.findAll());
        }catch(HttpServerErrorException.InternalServerError e){
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error Message goes here");
        }
    }

    @GetMapping("/get-30-days-persons")
    public ResponseEntity<List<Person>> get30DaysList(){
        return ResponseEntity.status(HttpStatus.OK).body(personService.get30DaysPersons());
    }

}
