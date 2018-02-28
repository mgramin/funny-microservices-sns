package com.github.mgramin.funny_microservices_sns.web_client.rest;

import com.github.mgramin.funny_microservices_sns.web_client.client.Account;
import com.github.mgramin.funny_microservices_sns.web_client.client.AccountClient;
import com.github.mgramin.funny_microservices_sns.web_client.client.Message;
import com.github.mgramin.funny_microservices_sns.web_client.client.MessageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    MessageClient messageClient;

    @Autowired
    AccountClient accountClient;

    @GetMapping("/message")
    @ResponseBody
    public Iterable<Message> findAllMessages() {
        return messageClient.getAllMessages();
    }

    @GetMapping("/account")
    @ResponseBody
    public Iterable<Account> findAllAccounts() {
        return accountClient.getAllAccounts();
    }

}
