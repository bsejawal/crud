package com.bsejawal.jpa.service;

import com.bsejawal.jpa.dto.PersonDto;
import com.bsejawal.jpa.entity.Person;
import com.bsejawal.jpa.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class PersonServiceTest {
    private final PersonRepository mockPersonRepository =mock(PersonRepository.class);
    private final ObjectMapper mockObjectMapper = mock(ObjectMapper.class);

    private PersonService subject = new PersonService(mockObjectMapper, mockPersonRepository);


    @Test
    void insert() {

        PersonDto dto = PersonDto.builder()
                .personId("123456789012345")
                .name("John Doe")
                .email("john@example.com")
                .phone("1234567890")
                .gender("Male")
                .dob(new Date())
                .build();

        when(mockPersonRepository.insert(anyString(), anyString(), anyString(), anyString(), anyString(), any(Date.class)))
                .thenReturn(1);

        assertTrue(subject.insert(dto));

        verify(mockPersonRepository, times(1)).insert(anyString(), anyString(), anyString(), anyString(), anyString(), any(Date.class));

    }

    @Test
    void get30DaysPersons() {
        List<Person> mockPersonList = new ArrayList<>();
        mockPersonList.add(new Person());
        mockPersonList.add(new Person());

        when(mockPersonRepository.findAllByCreatedAtAfter(any()))
                .thenReturn(mockPersonList);

        List<Person> result = subject.get30DaysPersons();

        assertEquals(mockPersonList.size(), result.size());
        assertEquals(mockPersonList.get(0), result.get(0));
        assertEquals(mockPersonList.get(1), result.get(1));

        verify(mockPersonRepository, times(1)).findAllByCreatedAtAfter(any());
    }
}