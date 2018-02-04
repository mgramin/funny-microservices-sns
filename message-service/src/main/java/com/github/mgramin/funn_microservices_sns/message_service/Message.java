package com.github.mgramin.funn_microservices_sns.message_service;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@ToString @Getter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID fromAccount;
    private UUID toAccount;
    private ZonedDateTime time;
    private String text;

    public Message() {
    }

    public Message(final UUID fromAccount, final UUID toAccount, final String text) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.text = text;
    }

}
