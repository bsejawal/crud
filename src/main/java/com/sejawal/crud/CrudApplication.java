package com.sejawal.crud;

import com.sejawal.crud.repository.UserRepository;
import com.sejawal.crud.utils.DataUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	CommandLineRunner init (UserRepository userRepository){
		if(0 == userRepository.count()) {
			return args -> {
				DataUtils.users().forEach(user -> userRepository.save(user));
			};
		}
		return null;
	}

}
