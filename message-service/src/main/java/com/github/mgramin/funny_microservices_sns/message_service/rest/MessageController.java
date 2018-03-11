package com.github.mgramin.funny_microservices_sns.message_service.rest;

import com.github.mgramin.funny_microservices_sns.message_service.Message;
import com.github.mgramin.funny_microservices_sns.message_service.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

import static java.util.UUID.randomUUID;


@Controller
public class MessageController {

    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageRepository messageRepository;

    @PostConstruct
    public void init(){
 			messageRepository.save(new Message(randomUUID(), randomUUID(), "Hello"));
			messageRepository.save(new Message(randomUUID(), randomUUID(), "Hello!"));
			messageRepository.save(new Message(randomUUID(), randomUUID(), "How do you do?"));
			messageRepository.save(new Message(randomUUID(), randomUUID(), "I'm fine"));
			messageRepository.save(new Message(randomUUID(), randomUUID(), "I'm too"));
    }


    @GetMapping("/message")
    @ResponseBody
    @Transactional(readOnly = true)
    public Iterable<Message> findAllMessages() {
        log.info("find all messages ...");
        return this.messageRepository.findAll();
    }

}
