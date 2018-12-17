package org.adfenp.cinealert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CinealertApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinealertApplication.class, args);
	}

}

