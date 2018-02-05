package com.github.mgramin.funn_microservices_sns.message_service.rest;

import com.github.mgramin.funn_microservices_sns.message_service.App;
import com.github.mgramin.funn_microservices_sns.message_service.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageControllerTest {

    @Autowired
    private TestRestTemplate restClient;

    @Test
    public void findAllmessages() {
        Message[] messages = restClient.getForObject("/message", Message[].class);//("/message", HttpMethod.GET);
        for (Message message : messages) {
            System.out.println(message);
        }
    }

}