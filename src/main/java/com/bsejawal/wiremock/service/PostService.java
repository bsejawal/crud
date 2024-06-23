package com.bsejawal.wiremock.service;

import com.bsejawal.wiremock.vo.PostResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);


    public PostResponse getPost(int id){
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://jsonplaceholder.typicode.com/posts/"+id;

        try {
            PostResponse response = restTemplate.getForObject(resourceUrl, PostResponse.class);
            logger.info("Response ####### = {}", response);
            return response;
        } catch (RestClientException e) {
            logger.error("Error occurred while fetching the post with id: "+id, e);
            return null;
        }
    }

    public List<PostResponse> getAllPosts(){
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://jsonplaceholder.typicode.com/posts";

        try {
            PostResponse[] responseArray = restTemplate.getForObject(resourceUrl, PostResponse[].class);
            List<PostResponse> responseList = Arrays.asList(responseArray);

            logger.info("ResponseList ####### = {}", responseList);
            return responseList;
        } catch (RestClientException e) {
            logger.error("Error occurred while fetching the posts:", e);
            return null;
        }

    }

}
