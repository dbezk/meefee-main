package com.meefee.main;

import com.meefee.main.constants.Roles;
import com.meefee.main.model.Role;
import com.meefee.main.repository.RoleRepository;
import com.meefee.main.service.shared.RegistrationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MainApplication {

	/* TODO:
		1. Add exceptions (and status codes);
		2. Add tests;
		3. Configure WS listening streams;
	 */
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, RegistrationService registrationService) {
		return args -> {
			roleRepository.save(new Role(Roles.ARTIST_ROLE));
			roleRepository.save(new Role(Roles.USER_ROLE));
		};
	}

}
