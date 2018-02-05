package com.github.mgramin.funn_microservices_sns.message_service;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MessageRepository extends MongoRepository<Message, UUID> {

//    List<Message> findByFromAccount(UUID from);

}
