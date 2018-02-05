package com.github.mgramin.funny_microservices_sns.account_service;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "message")
@ToString @Getter
public class Account {

    private String id;
    private String firstName;
    private String lastName;

    protected Account() {
    }

    public Account(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
