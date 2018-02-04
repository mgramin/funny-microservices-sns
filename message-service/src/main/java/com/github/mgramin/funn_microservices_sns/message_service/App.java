package com.github.mgramin.funn_microservices_sns.message_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	@Autowired
    MessageRepository repository;

	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
	}

}
