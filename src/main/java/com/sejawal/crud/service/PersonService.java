package com.sejawal.crud.service;

import com.sejawal.crud.dto.PersonDto;
import com.sejawal.crud.mapper.PersonMapper;
import com.sejawal.crud.model.Person;
import com.sejawal.crud.repository.PersonRepository;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public PersonDto updatePersonFields(Long id, Map<String, Object> fields){
        Optional<Person> existingPerson = personRepository.findById(id);
        if(existingPerson.isPresent()){
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Person.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingPerson.get(), value);
            });
            Person person = personRepository.save(existingPerson.get());
            return PersonMapper.mapToPersonDto(person, new PersonDto());
        }
        return null;

    }


}
