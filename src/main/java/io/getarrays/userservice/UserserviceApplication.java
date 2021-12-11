package io.getarrays.userservice;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Renu", "renukalavakuri", "#knagamma1", new ArrayList<>()));
			userService.saveUser(new User(null, "Padmaja", "paddu", "#knagamma1", new ArrayList<>()));
			userService.saveUser(new User(null, "Geethika", "laddu", "#knagamma1", new ArrayList<>()));
			userService.saveUser(new User(null, "Aaruhi", "duddle", "#knagamma1", new ArrayList<>()));

			userService.addRoleToUser("renukalavakuri", "ROLE_USER");
			userService.addRoleToUser("renukalavakuri", "ROLE_MANAGER");
			userService.addRoleToUser("paddu", "ROLE_MANAGER");
			userService.addRoleToUser("laddu", "ROLE_ADMIN");
			userService.addRoleToUser("duddle", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("duddle", "ROLE_ADMIN");
			userService.addRoleToUser("duddle", "ROLE_USER");
		};
	}
}
