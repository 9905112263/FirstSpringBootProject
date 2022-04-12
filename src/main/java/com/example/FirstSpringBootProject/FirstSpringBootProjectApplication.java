package com.example.FirstSpringBootProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages="com.app")
public class FirstSpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootProjectApplication.class, args);
		System.out.println("Hello");
		System.out.println("jhgljhfld");
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}

}
