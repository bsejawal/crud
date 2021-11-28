package com.sejawal.crud;

import com.sejawal.crud.entity.Post;
import com.sejawal.crud.payload.PostDto;
import com.sejawal.crud.service.PostService;
import com.sejawal.crud.utils.DataUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	CommandLineRunner init (PostService postService){
		return args -> {
			Set<PostDto> posts = DataUtils.posts();
			posts.forEach(postDto -> postService.createPost(postDto));
		};
	}
}
