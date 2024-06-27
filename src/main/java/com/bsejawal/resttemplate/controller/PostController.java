package com.bsejawal.resttemplate.controller;

import com.bsejawal.resttemplate.service.PostService;
import com.bsejawal.resttemplate.vo.PostRequest;
import com.bsejawal.resttemplate.vo.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/posts")
    public ResponseEntity<PostResponse> savePost(@RequestBody PostRequest postRequest){
        PostResponse response = postService.savePost(postRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<PostResponse> update(@PathVariable int id, @RequestBody PostRequest postRequest){
        PostResponse response = postService.updatePost(id, postRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
