package com.sejawal.crud.controller;

import com.sejawal.crud.model.Person;
import com.sejawal.crud.repository.PersonRepository;
import com.sejawal.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    private final PersonRepository personRepository;

    PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping(value = "/status")
    public String status(){
        System.out.println("called /status");
        return "if you see this the app is working fine, celebrate!!";
    }
    @GetMapping(value = "/persons")
    public List<Person> all(){
        return (List<Person>) personRepository.findAll();
    }
    @GetMapping(value = "/persons/{id}")
    public Person one(@PathVariable(value="id") Long id){
        return personRepository.findById(id).orElse(null);
    }

    @PutMapping(value = "/persons/{id}")
    public Person replacePerson(@RequestBody Person newPerson, @PathVariable(value = "id") Long id){
        return personRepository.findById(id)
                .map(person -> {
                    person.setAddress(newPerson.getAddress());
                    person.setName(newPerson.getName());
                    person.setEmail(newPerson.getEmail());
                    return personRepository.save(newPerson);
                }).orElseGet(() -> {
                    newPerson.setId(id);
                    return personRepository.save(newPerson);
                });
    }
    @DeleteMapping(value = "/persons/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        personRepository.deleteById(id);
    }

    @PostMapping(value = "/persons")
    public Person add(@RequestBody Person person){
        personRepository.save(person);
        return person;

    }
    @RequestMapping(value = "/test")
    public String test(){
        return "test Working!! ";
    }
}
