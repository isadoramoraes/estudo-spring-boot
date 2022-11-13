package com.example.estudospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoAuditing
@EntityScan(basePackages = "com.example.estudospringboot.model")
@EnableMongoRepositories(basePackages = "com.example.estudospringboot.core.repository")
@SpringBootApplication(scanBasePackages = "com.example.estudospringboot")
public class EstudoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudoSpringBootApplication.class, args);

		//System.out.println("Hello, World!");
	}

}
