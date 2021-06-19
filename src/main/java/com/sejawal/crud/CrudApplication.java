package com.sejawal.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudApplication.class, args);
	}

//	@Bean
//	CommandLineRunner init (PersonRepository personRepository){
//		return args -> {
//			List<Person> persons=DataUtils.persons();
//			persons.forEach(person -> personRepository.save(person));
//		};
//	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				System.out.println("CrudApplication.addCorsMappings");
//				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
//			}
//		};
//	}
}
