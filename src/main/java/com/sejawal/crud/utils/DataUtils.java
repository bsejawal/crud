
package com.sejawal.crud.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sejawal.crud.model.User;
//import com.sejawal.crud.vo.PersononList;
import com.sejawal.crud.vo.UserList;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DataUtils {
    /*
//    public static List<Person> persons(){
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//                PersonList personList = null;
//
//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        try(InputStream input = loader.getResourceAsStream("data"+File.separator+"person.json")){
//            personList = mapper.readValue(input, PersonList.class);
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
////        try {
////            personList =  mapper.readValue(new File("src/main/resources/data/person.json"), PersonList.class);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//        return personList.getPersonList();



//    }

*/
    public static List<User> users(){
        return ((UserList)readJsonFileAndMapToObject("data"+File.separator+"user.json", UserList.class)).getUserList();
    }

    public static User user(){
        return ((UserList)readJsonFileAndMapToObject("data"+File.separator+"user.json", UserList.class)).getUserList().get(0);
    }

    private static <T> T readJsonFileAndMapToObject(String filePath, Class<T> element){
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        T t = null;
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try(InputStream input = loader.getResourceAsStream(filePath)){
            t =  mapper.readValue(input, element);

        }catch (IOException e){
            e.printStackTrace();
        }
        return t;
    }

}

