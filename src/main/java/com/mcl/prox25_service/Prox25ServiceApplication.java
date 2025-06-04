package com.mcl.prox25_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.mcl.prox25_service.repository.sql") // JPA repos
@EnableMongoRepositories(basePackages = "com.mcl.prox25_service.repository.mongo") // mongo repos

public class Prox25ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Prox25ServiceApplication.class, args);
	}

}
