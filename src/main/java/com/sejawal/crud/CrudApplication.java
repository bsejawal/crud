package com.sejawal.crud;

import com.sejawal.crud.model.Person;
import com.sejawal.crud.repository.PersonRepository;
import com.sejawal.crud.utils.DataUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	CommandLineRunner init (PersonRepository personRepository){
		return args -> {
			List<Person> persons=DataUtils.persons();
			persons.forEach(person -> personRepository.save(person));
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
