package com.bsejawal.jpa.controller;

import com.bsejawal.jpa.dto.PersonDto;
import com.bsejawal.jpa.entity.Person;
import com.bsejawal.jpa.repository.PersonRepository;
import com.bsejawal.jpa.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




//@WebMvcTest(PersonController.class)
//@AutoConfigureMockMvc
class PersonControllerTest {

    private MockMvc mockMvc;

    private PersonRepository mockPersonRepository =mock(PersonRepository.class);
    private PersonService mockPersonService = mock(PersonService.class);
    private PersonController subject = new PersonController(mockPersonRepository, mockPersonService);

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(subject).build();
    }


    @Test
    void testSave() throws Exception {
        // Prepare test data
        PersonDto personDto = PersonDto.builder()
                .personId("123456789012345")
                .name("John")
                .email("john@example.com")
                .phone("1234567890")
                .gender("M")
                .dob(new SimpleDateFormat("MM/dd/yyyy").parse("07/28/1989"))
                .build();
        Person person = personDto.mapToPerson();

        // Mock the behavior of personRepository.save()
        when(mockPersonRepository.save(person)).thenReturn(person);

        // Verify the response
        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"personId\":\"123456789012345\",\n" +
                                "    \"name\": \"John\",\n" +
                                "    \"email\":\"john@example.com\",\n" +
                                "    \"phone\" :\"1234567890\",\n" +
                                "    \"gender\":\"M\",\n" +
                                "    \"dob\":\"07/28/1989\"\n" +
                                "}"))
                .andExpect(status().isCreated())
                .andDo(print());
//                .andExpect(jsonPath("$.['name']").value("John"));
//                .andExpect(jsonPath("$.name").value("John"));
    }

    @Test
    public void testGetAll() throws Exception {
        List<Person> persons = Arrays.asList(
                Person.builder()
                        .personId("123456789012345")
                        .name("John")
                        .email("john@example.com")
                        .phone("1234567890")
                        .gender("M")
                        .dob(new SimpleDateFormat("MM/dd/yyyy").parse("07/28/1989"))
                        .build(),
                Person.builder()
                        .personId("123456089012345")
                        .name("John2")
                        .email("john@example.com")
                        .phone("1234567880")
                        .gender("M")
                        .dob(new SimpleDateFormat("MM/dd/yyyy").parse("07/28/1989"))
                        .build()
        );

        when(mockPersonRepository.findAll()).thenReturn(persons);

        mockMvc.perform(get("/persons"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(persons.size())))
                .andExpect(jsonPath("$.[0].['name']").value("John"))
                .andExpect(jsonPath("$.[1].['name']").value("John2"))
                .andDo(print());
    }
    @Test
    public void testGet30DaysList() throws Exception {
        List<Person> persons = Arrays.asList(
                Person.builder()
                        .personId("123456789012345")
                        .name("John")
                        .email("john@example.com")
                        .phone("1234567890")
                        .gender("M")
                        .dob(new SimpleDateFormat("MM/dd/yyyy").parse("07/28/1989"))
                        .build(),
                Person.builder()
                        .personId("123456089012345")
                        .name("John2")
                        .email("john@example.com")
                        .phone("1234567880")
                        .gender("M")
                        .dob(new SimpleDateFormat("MM/dd/yyyy").parse("07/28/1989"))
                        .build()
        );

        when(mockPersonService.get30DaysPersons()).thenReturn(persons);

        mockMvc.perform(get("/get-30-days-persons"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(persons.size())));
    }

}