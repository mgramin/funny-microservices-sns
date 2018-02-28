package com.github.mgramin.funny_microservices_sns.web_client.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("message-service")
public interface MessageClient {

    @RequestMapping("/message")
    Iterable<Message> getAllMessages();

}
