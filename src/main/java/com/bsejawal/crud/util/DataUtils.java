package com.bsejawal.crud.util;

import com.bsejawal.crud.payload.RoleRegistrationDto;
import com.bsejawal.crud.payload.UserRegistrationDto;
import com.bsejawal.crud.payload.vo.RoleRegistrationDtoSet;
import com.bsejawal.crud.payload.vo.UserRegistrationDtoSet;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class DataUtils {
    private final static String FILE_BASE_PATH = "_mock_data"+ File.separator;
    private static <T> T readJsonFileToObject(String filePath, Class<T> element){
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        T t = null;
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try(InputStream input = loader.getResourceAsStream(filePath)){
            t = mapper.readValue(input, element);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("t = " + t);
        return t;
    }

    public static Set<UserRegistrationDto> loadUsers(){
       return readJsonFileToObject(FILE_BASE_PATH+"userRegistrationDto.json", UserRegistrationDtoSet.class).getUserRegistrationDtoSet();
    }
    public static UserRegistrationDto getFirstUser(){
        return ((UserRegistrationDtoSet)readJsonFileToObject(FILE_BASE_PATH+"userRegistrationDto.json", UserRegistrationDtoSet.class)).getUserRegistrationDtoSet().stream().findFirst().get();
    }
    public static Set<RoleRegistrationDto> loadRoles(){
        return readJsonFileToObject(FILE_BASE_PATH+"roleRegistrationDto.json", RoleRegistrationDtoSet.class).getRoleRegistrationDtoSet();
    }
    public static RoleRegistrationDto getFirstRole(){
        return ((RoleRegistrationDtoSet)readJsonFileToObject(FILE_BASE_PATH+"roleRegistrationDto.json", RoleRegistrationDtoSet.class)).getRoleRegistrationDtoSet().stream().findFirst().get();
    }
}
