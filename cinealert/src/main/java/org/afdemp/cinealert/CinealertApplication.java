package org.afdemp.cinealert;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) // turn on spring security



public class CinealertApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CinealertApplication.class, args);
		
		
		
//		System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
	}

}

