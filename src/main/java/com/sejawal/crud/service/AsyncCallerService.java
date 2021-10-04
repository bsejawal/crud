package com.sejawal.crud.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncCallerService {
    @Autowired
    private RestTemplate restTemplate;
    @Async
    public CompletableFuture<JsonNode> callOtherService(){
        String otherServiceEndPoint = "https://jsonplaceholder.typicode.com/comments?postId=2";
        JsonNode responseObj = restTemplate.getForObject(otherServiceEndPoint, JsonNode.class);
        return CompletableFuture.completedFuture(responseObj);

    }
}
