package com.bsejawal.crud;

import com.bsejawal.crud.model.Role;
import com.bsejawal.crud.model.User;
import com.bsejawal.crud.repository.RoleRepository;
import com.bsejawal.crud.repository.UserRepository;
import com.bsejawal.crud.util.DataUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

//	@Bean
//	CommandLineRunner init (UserRepository userRepository, RoleRepository roleRepository){
////		if(0 == userRepository.count()){
//			return args -> {
//				DataUtils.loadRoles().forEach(roleDto -> {
//					Role role = new Role();
//					role.setName(roleDto.getName());
//					roleRepository.saveAndFlush(role);
//				}) ;
//				DataUtils.loadUsers().forEach(userDto -> {
//					User user = new User();
//					user.setUsername(userDto.getUsername());
//					user.setPassword(userDto.getPassword());
//					if(user.getUsername().equalsIgnoreCase("user")){
//						user.setRoles(new HashSet<>(Arrays.asList(roleRepository.findByName("USER").get())));
//					}else{
//						user.setRoles(new HashSet<>(Arrays.asList(roleRepository.findByName("ADMIN").get())));
//					}
//					userRepository.save(user);
//				});
//
//			};
//		}
//	}

}
