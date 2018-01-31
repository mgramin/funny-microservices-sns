package com.github.mgramin.funny_microservices_sns.account_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	@Autowired
    AccountRepository repository;

	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
	}

}
