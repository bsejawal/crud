package com.bsejawal.wiremock.controller;

import com.bsejawal.wiremock.service.PostService;
import com.bsejawal.wiremock.vo.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable int id){
        PostResponse response =  postService.getPost(id);
        System.out.println("response = " + response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/posts")
    public ResponseEntity<List<PostResponse>> getAllPost(){
        List<PostResponse> response =  postService.getAllPosts();
        System.out.println("response = " + response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
