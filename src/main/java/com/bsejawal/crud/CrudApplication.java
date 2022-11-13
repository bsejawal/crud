package com.bsejawal.crud;

import com.bsejawal.crud.model.User;
import com.bsejawal.crud.repository.UserRepository;
import com.bsejawal.crud.util.DataUtils;
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
		if(0 == userRepository.count()){
			return args -> {
				DataUtils.loadUsers().forEach(userDto -> {
					User user = new User();
					user.setUsername(userDto.getUsername());
					user.setPassword(userDto.getPassword());
					userRepository.save(user);
				});
			};
		}
		return null;
	}

}
