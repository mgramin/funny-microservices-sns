package com.github.mgramin.funny_microservices_sns.message_service.rest;

import com.github.mgramin.funny_microservices_sns.message_service.App;
import com.github.mgramin.funny_microservices_sns.message_service.Message;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testcontainers.containers.GenericContainer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = MessageControllerTest.Initializer.class)
public class MessageControllerTest {

    private static final int CASSANDRA_PORT = 9042;

    @ClassRule
    public static GenericContainer cassandra = new GenericContainer("cassandra:latest")
            .withExposedPorts(CASSANDRA_PORT);

    @Autowired
    private TestRestTemplate restClient;


    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            EnvironmentTestUtils.addEnvironment("testcontainers", configurableApplicationContext.getEnvironment(),
                    "cassandra.host=" + cassandra.getContainerIpAddress(),
                    "cassandra.port=" + cassandra.getMappedPort(CASSANDRA_PORT)
            );
        }
    }

    @Test
    public void findAllmessages() {
        Message[] messages = restClient.getForObject("/message", Message[].class);
        for (Message message : messages) {
            System.out.println(message);
        }
    }

}