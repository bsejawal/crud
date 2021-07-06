package com.sejawal.crud.controller;

import com.sejawal.crud.service.UserService;
import com.sejawal.crud.utils.DataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)  // For Junit5
class UserControllerTest {

    @Mock
    private WebApplicationContext wac;


    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;


    private MockMvc mockMvc;

    @BeforeEach
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

    }

    @Test
    public void test() throws Exception{
        when(userService.findAll()).thenReturn(DataUtils.users());
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andDo(print());

    }


}