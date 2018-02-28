package com.github.mgramin.funny_microservices_sns.web_client.client;

import lombok.Getter;
import lombok.ToString;

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
