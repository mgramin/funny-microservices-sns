package com.github.mgramin.funny_microservices_sns.account_service.rest;

import com.github.mgramin.funny_microservices_sns.account_service.Account;
import com.github.mgramin.funny_microservices_sns.account_service.App;
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

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = AccountControllerTest.Initializer.class)
public class AccountControllerTest {

    private static final int MONGO_PORT = 27017;

    @ClassRule
    public static GenericContainer mongo = new GenericContainer("mongo:latest")
            .withExposedPorts(MONGO_PORT);

    @Autowired
    private TestRestTemplate restClient;


    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            EnvironmentTestUtils .addEnvironment("testcontainers", configurableApplicationContext.getEnvironment(),
                    "spring.data.mongodb.host=" + mongo.getContainerIpAddress(),
                    "spring.data.mongodb.port=" + mongo.getMappedPort(MONGO_PORT)
            );
        }
    }

    @Test
    public void findAllAccounts() {
        final Account[] accounts = restClient.getForObject("/account", Account[].class);
        assertEquals(5,accounts.length);
    }

}