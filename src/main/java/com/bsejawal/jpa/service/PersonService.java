package com.bsejawal.jpa.service;

import com.bsejawal.jpa.dto.PersonDto;
import com.bsejawal.jpa.entity.Person;
import com.bsejawal.jpa.repository.PersonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class PersonService {

    private final ObjectMapper objectMapper;
    private final PersonRepository personRepository;

    public PersonService(ObjectMapper objectMapper, PersonRepository personRepository) {
        this.objectMapper = objectMapper;
        this.personRepository = personRepository;
    }

    public void create(
            @NonNull String personId,
            @NonNull String name,
            @NonNull String email,
            @Nullable String phone,
            @Nullable Object object //will change this data type to String later
    ){
       Person person =  Person.builder()
                .personId(personId)
                .name(name)
                .email(email)
                .phone(phone)
                .gender(writeValueAsString(object))
                .build();
        personRepository.save(person);



//        // Set up test data
//        String personId = "testPersonId";
//        String name = "Test Name";
//        String email = "test@example.com";
//        String phone = "1234567890";
//        Object object = new Object(); // Will be serialized as JSON
//
//        // Call the method under test
//        personService.create(personId, name, email, phone, object);
//
//        // Verify interactions with mock
//        verify(personRepository).save(any(Person.class));
    }

   public boolean insert(PersonDto dto){
        return personRepository.insert(dto.getPersonId(), dto.getName(), dto.getEmail(), dto.getPhone(), dto.getGender(), dto.getDob()) > 0;
//        if(i )
//            return true;
//        else return false;
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
