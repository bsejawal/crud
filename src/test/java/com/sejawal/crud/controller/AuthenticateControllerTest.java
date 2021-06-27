package com.sejawal.crud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sejawal.crud.model.AuthenticationRequest;
import com.sejawal.crud.model.User;
import com.sejawal.crud.service.MyUserDetails;
import com.sejawal.crud.service.MyUserDetailsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AuthenticateController.class)
class AuthenticateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private AuthenticateController authenticateController;

    @Mock
    private MyUserDetailsService myUserDetailsService;

    @Test
    void hello() {
        AuthenticateController ac = new AuthenticateController();
        String response = ac.hello("World");
        assertEquals("Hello World", response);
    }
    @Test
    @DisplayName("GET /hello will get the default paramValue")
    void helloWithMockito() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("GET /hello?name=Bhesh success")
    void helloWithName() throws Exception {
        mockMvc.perform(get("/hello?name=Bhesh"))
                .andExpect(content().string("Hello Bhesh"));
    }

    @Test
    @DisplayName("POST /authenticate success")
    void authenticate() throws Exception {
        AuthenticationRequest aRequest = new AuthenticationRequest("foo", "foo");
        User user = new User("foo", "foo", true, "ROLE_USER");
        given(myUserDetailsService.loadUserByUsername("foo")).willReturn(new MyUserDetails(user));
//        Mockito.given(myUserDetailsService.loadUserByUsername("foo")).thenReturn(new MyUserDetails(user));
        mockMvc.perform(post("/authenticate")
                .contentType("application/json")
                .content(asJsonString(aRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.jwt", is("foo")));
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}