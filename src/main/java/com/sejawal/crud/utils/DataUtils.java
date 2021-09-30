package com.sejawal.crud.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sejawal.crud.model.User;
import com.sejawal.crud.vo.UserSet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

public class DataUtils {
    public static Set<User> users(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                UserSet userSet = null;
//
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try(InputStream input = loader.getResourceAsStream("data"+File.separator+"user.json")){
            userSet = mapper.readValue(input, UserSet.class);

        }catch (IOException e){
            e.printStackTrace();
        }
//
//        try {
//            userSet =  mapper.readValue(new File("src/main/resources/data/user.json"), UserSet.class);
//            System.out.println("at try :::");
//        } catch (IOException e) {
//            System.out.println("at catch ::::");
//            e.printStackTrace();
//        }
        System.out.println("DATA LOADING :: >>"+userSet.getUserSet().size()+" >>" + userSet.getUserSet());
        return userSet.getUserSet();



    }
}
