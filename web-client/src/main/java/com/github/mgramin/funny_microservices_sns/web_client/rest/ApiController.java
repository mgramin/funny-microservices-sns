package com.github.mgramin.funny_microservices_sns.web_client.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);


    @GetMapping("/message")
    @ResponseBody
    public String findAllMessages() {
        return "all messages ...";
    }

    @GetMapping("/account")
    @ResponseBody
    public String findAllAccounts() {
        return "all accounts ...";
    }

}
