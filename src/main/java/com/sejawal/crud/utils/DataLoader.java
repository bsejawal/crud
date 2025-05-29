package com.sejawal.crud.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sejawal.crud.dto.PersonDto;
import com.sejawal.crud.mapper.PersonMapper;
import com.sejawal.crud.model.Person;
import com.sejawal.crud.repository.PersonRepository;
import com.sejawal.crud.vo.PersonDtoList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final PersonRepository personRepository;
    public DataLoader(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) {
        List<PersonDto> personDtoList = loadFromJsonToPersonDto();
        List<Person> personList = new ArrayList<>();
        personDtoList.forEach(person -> personList.add(PersonMapper.mapToPerson(person, new Person())));
        System.out.println("personList size: "+personList.size());
        personRepository.saveAll(personList);
    }

    public  List<PersonDto> loadFromJsonToPersonDto(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        PersonDtoList personDtoList = null;

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try(InputStream input = loader.getResourceAsStream("data"+ File.separator+"person.json")){
            personDtoList = mapper.readValue(input, PersonDtoList.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        return personDtoList.getPersonList();
    }
}
