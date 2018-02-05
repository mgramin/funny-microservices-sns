package com.github.mgramin.funny_microservices_sns.account_service;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account, Long> {

    List<Account> findByLastName(String lastName);

}
