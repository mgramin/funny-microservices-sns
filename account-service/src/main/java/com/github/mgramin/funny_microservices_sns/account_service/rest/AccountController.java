package com.github.mgramin.funny_microservices_sns.account_service.rest;

import com.github.mgramin.funny_microservices_sns.account_service.Account;
import com.github.mgramin.funny_microservices_sns.account_service.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;


@Controller
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountRepository accountRepository;

    @PostConstruct
    public void init(){
 			accountRepository.save(new Account("Jack", "Bauer"));
			accountRepository.save(new Account("Chloe", "O'Brian"));
			accountRepository.save(new Account("Kim", "Bauer"));
			accountRepository.save(new Account("David", "Palmer"));
			accountRepository.save(new Account("Michelle", "Dessler"));
    }


    @GetMapping("/account")
    @ResponseBody
    @Transactional(readOnly = true)
    public Iterable<Account> findAllAccounts() {
        return this.accountRepository.findAll();
    }

}
