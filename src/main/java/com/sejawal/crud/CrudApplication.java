package com.sejawal.crud;

import com.sejawal.crud.model.User;
import com.sejawal.crud.repository.UserRepository;
import com.sejawal.crud.utils.DataUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	CommandLineRunner init (UserRepository userRepository){
		return args -> {
			Set<User> users =DataUtils.users();
			users.forEach(user -> userRepository.save(user));
		};
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				System.out.println("CrudApplication.addCorsMappings");
				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
			}
		};
	}
}
