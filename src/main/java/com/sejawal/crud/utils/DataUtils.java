package com.sejawal.crud.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sejawal.crud.payload.PostDto;
import com.sejawal.crud.payload.PostDtoSet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class DataUtils {
    public static Set<PostDto> posts(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                PostDtoSet postSet = null;
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try(InputStream input = loader.getResourceAsStream("data"+ File.separator+"posts.json")){
            postSet = mapper.readValue(input, PostDtoSet.class);

        }catch (IOException e){
            e.printStackTrace();
        }
        return postSet.getPostDtoSet();
    }
}
