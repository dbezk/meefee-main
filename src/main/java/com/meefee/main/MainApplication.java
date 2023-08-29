package com.meefee.main;

import com.meefee.main.constants.Roles;
import com.meefee.main.dto.NewAccountDTO;
import com.meefee.main.model.Role;
import com.meefee.main.repository.RoleRepository;
import com.meefee.main.service.RegistrationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, RegistrationService registrationService) {
		return args -> {
			roleRepository.save(new Role(Roles.ARTIST_ROLE));
			roleRepository.save(new Role(Roles.USER_ROLE));

			registrationService.registerUser(new NewAccountDTO("alex@laradov.com", "password123"));
			registrationService.registerUser(new NewAccountDTO("nikita@volant.com", "password123"));
		};
	}

}
