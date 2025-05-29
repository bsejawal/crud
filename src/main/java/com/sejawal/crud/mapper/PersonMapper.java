package com.sejawal.crud.mapper;

import com.sejawal.crud.dto.PersonDto;
import com.sejawal.crud.model.Person;

public class PersonMapper {

    public static PersonDto mapToPersonDto(Person person, PersonDto personDto){
        personDto.setId(person.getId());
        personDto.setName(person.getName());
        personDto.setAddress(person.getAddress());
        personDto.setEmail(person.getEmail());
        return personDto;
    }

    public static Person mapToPerson(PersonDto personDto, Person person){
        person.setName(personDto.getName());
        person.setAddress(personDto.getAddress());
        person.setEmail(personDto.getEmail());
        return person;
    }
}
