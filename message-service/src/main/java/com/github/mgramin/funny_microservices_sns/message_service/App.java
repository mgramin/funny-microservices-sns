package com.github.mgramin.funny_microservices_sns.message_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.github.mgramin.funny_microservices_sns.message_service")
public class App {

	@Autowired
    MessageRepository repository;

	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
	}

}
