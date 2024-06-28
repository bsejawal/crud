package com.bsejawal.resttemplate.service;

import com.bsejawal.resttemplate.vo.PostRequest;
import com.bsejawal.resttemplate.vo.PostResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    @Autowired
    RestTemplate restTemplate;


    public PostResponse getPost(int id) {
        String resourceUrl = "https://jsonplaceholder.typicode.com/posts/" + id;

        try {
            PostResponse response = restTemplate.getForObject(resourceUrl, PostResponse.class);
            logger.info("Response ####### = {}", response);
            return response;
        } catch (RestClientException e) {
            logger.error("Error occurred while fetching the post with id: " + id, e);
            return null;
        }
    }

    public List<PostResponse> getAllPosts() {
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

    public PostResponse savePost(PostRequest postRequest) {
        String resourceUrl = "https://jsonplaceholder.typicode.com/posts";

        HttpEntity<PostRequest> request = new HttpEntity<PostRequest>(postRequest);
        try {
            ResponseEntity<PostResponse> postResponseEntity =
                    restTemplate
                            .exchange(resourceUrl,
                                    HttpMethod.POST,
                                    request,
                                    PostResponse.class);
            logger.info("Response ####### = {}", postResponseEntity);
            return postResponseEntity.getBody();
        } catch (RestClientException e) {
            logger.error("error occurred while creating post :" + postRequest);
            return null;
        }

    }

    public PostResponse updatePost(int id, PostRequest postRequest) {
        String resourceUrl = "https://jsonplaceholder.typicode.com/posts/" + id;

        HttpEntity<PostRequest> request = new HttpEntity<PostRequest>(postRequest);

        try {
            ResponseEntity<PostResponse> postResponseEntity =
                    restTemplate
                            .exchange(resourceUrl,
                                    HttpMethod.PUT,
                                    request,
                                    PostResponse.class);
            logger.info("Response ####### = {}", postResponseEntity);
            return postResponseEntity.getBody();
        } catch (RestClientException e) {
            logger.error("error occurred while creating post :" + postRequest);
            return null;
        }
    }

    public ResponseEntity<PostResponse> sendPatchRequest(int id, PostRequest postRequest) {
        String resourceUrl = "https://jsonplaceholder.typicode.com/posts/" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<PostRequest> requestEntity = new HttpEntity<>(postRequest, headers);
        ResponseEntity<PostResponse> responseEntity = restTemplate.exchange(
                resourceUrl, HttpMethod.PATCH, requestEntity, PostResponse.class
        );
        return responseEntity;
    }
}
