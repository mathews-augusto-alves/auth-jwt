package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.test", "br.com.project"})
public class TestAuthJWTApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestAuthJWTApplication.class, args);
	}

}
