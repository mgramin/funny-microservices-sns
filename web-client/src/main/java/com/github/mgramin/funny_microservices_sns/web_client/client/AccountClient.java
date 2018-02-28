package com.github.mgramin.funny_microservices_sns.web_client.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("account-service")
public interface AccountClient {

    @RequestMapping("/account")
    Iterable<Account> getAllAccounts();

}
