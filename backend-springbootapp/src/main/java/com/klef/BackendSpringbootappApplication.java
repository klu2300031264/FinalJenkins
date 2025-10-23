package com.klef;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendSpringbootappApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BackendSpringbootappApplication.class, args);
		System.out.println("Spring Boot Project is Running ...");
	}

}
