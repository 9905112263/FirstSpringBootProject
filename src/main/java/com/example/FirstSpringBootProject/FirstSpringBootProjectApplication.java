package com.example.FirstSpringBootProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.ws.security.AppProperties;
//@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
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
	@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}
	@Bean(name="appProperties")
	public AppProperties getAppProperties() {
		
		return new AppProperties();
	}

}
