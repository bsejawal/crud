package com.sejawal.crud;

import com.sejawal.crud.model.User;
import com.sejawal.crud.repository.UserRepository;
import com.sejawal.crud.utils.DataUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class CrudApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudApplication.class, args);
	}
	@Bean
	CommandLineRunner init (UserRepository userRepository){
		return args -> {
			List<User> users= DataUtils.users();
			System.out.println(users.size() );
			System.out.println(users);
			users.forEach(user -> userRepository.save(user));
		};
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
