package org.adfenp.cinealert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) // turn on spring security



public class CinealertApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinealertApplication.class, args);
	}

}

