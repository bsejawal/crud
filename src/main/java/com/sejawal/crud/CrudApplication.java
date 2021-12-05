package com.sejawal.crud;

import com.sejawal.crud.payload.CommentDtoSet;
import com.sejawal.crud.payload.RoleDto;
import com.sejawal.crud.service.CommentService;
import com.sejawal.crud.service.PostService;
import com.sejawal.crud.service.RoleService;
import com.sejawal.crud.service.UserService;
import com.sejawal.crud.utils.DataUtils;
import org.modelmapper.ModelMapper;
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
	CommandLineRunner init (
			PostService postService,
			CommentService commentService,
			RoleService roleService,
			UserService userService
	){
		return args -> {
			DataUtils
					.posts()
					.forEach(postDto -> postService.createPost(postDto));
			CommentDtoSet comments = DataUtils.comments();
			comments
					.getCommentDtoSet()
					.forEach(commentDto -> commentService.createComment(comments.getPostId(),commentDto));

			DataUtils.users().getUserDtoSet().forEach(userDto -> {
				if(userDto.getUsername().equals("user")) {
					RoleDto roleDto = DataUtils.roles().getRoleDtoSet().stream().filter(r->r.getName().equals("ROLE_USER")).findFirst().orElse(null);
					userDto.getRoles().add(roleDto);
				}else if(userDto.getUsername().equals("admin")){
					RoleDto roleDto = DataUtils.roles().getRoleDtoSet().stream().filter(r->r.getName().equals("ROLE_ADMIN")).findFirst().orElse(null);
					userDto.getRoles().add(roleDto);

				}else if(userDto.getUsername().equals("super")){
					RoleDto roleDto = DataUtils.roles().getRoleDtoSet().stream().filter(r->r.getName().equals("ROLE_SUPER_ADMIN")).findFirst().orElse(null);
					userDto.getRoles().add(roleDto);
				}
				userService.createRole(userDto);
			});
		};
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}