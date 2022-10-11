package com.sejawal.crud.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sejawal.crud.model.Person;
import com.sejawal.crud.vo.PersonList;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DataUtils {
    public static List<Person> persons(){
        System.out.println("true = " + true);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                PersonList personList = null;

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try(InputStream input = loader.getResourceAsStream("data"+File.separator+"person.json")){
            personList = mapper.readValue(input, PersonList.class);

        }catch (IOException e){
            e.printStackTrace();
        }

//        try {
//            personList =  mapper.readValue(new File("src/main/resources/data/person.json"), PersonList.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return personList.getPersonList();



    }
}
