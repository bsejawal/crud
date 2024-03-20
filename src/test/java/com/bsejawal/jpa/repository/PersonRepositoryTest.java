package com.bsejawal.jpa.repository;

import com.bsejawal.jpa.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@TestPropertySource(properties = {"spring.config.location=classpath:application-test.yml"})
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) // reset data after each Test run
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;



    @Test
    public void testInsert() throws Exception{
        int result = personRepository.insert(
                "123456789012345",
                "John1",
                "john@example.com",
                "1234567890",
                "Male",
                new SimpleDateFormat("MM/dd/yyyy").parse("07/28/1989"));
        assertEquals(1, result);
    }

    @Test
    public void testFind30DaysPersons() throws ParseException {
        List<Person> persons = Arrays.asList(
                Person.builder()
                        .personId("123456789012345")
                        .name("John2")
                        .email("john@example.com")
                        .phone("1234567890")
                        .gender("M")
                        .dob(new SimpleDateFormat("MM/dd/yyyy").parse("07/28/1989"))
                        .build(),
                Person.builder()
                        .personId("123456789012346")
                        .name("John3")
                        .email("john2@example.com")
                        .phone("1234567890")
                        .gender("M")
                        .dob(new SimpleDateFormat("MM/dd/yyyy").parse("07/28/1989"))
                        .build()
        );
        personRepository.saveAll(persons);
        List<Person> personsWithin30Days = personRepository.findAllByCreatedAtAfter(Instant.now().minus(Duration.ofDays(30)));
        System.out.println("personsWithin30Days = " + personsWithin30Days);
        assertEquals(2, personsWithin30Days.size());
        assertEquals("John2", personsWithin30Days.get(0).getName());
    }
}