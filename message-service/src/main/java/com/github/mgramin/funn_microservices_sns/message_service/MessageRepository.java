package com.github.mgramin.funn_microservices_sns.message_service;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends CrudRepository<Message, UUID> {

    List<Message> findByFromAccount(UUID from);

}
