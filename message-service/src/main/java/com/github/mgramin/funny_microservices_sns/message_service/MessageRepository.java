package com.github.mgramin.funny_microservices_sns.message_service;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MessageRepository extends CrudRepository<Message, UUID> {}
