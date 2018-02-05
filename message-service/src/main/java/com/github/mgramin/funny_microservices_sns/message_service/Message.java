package com.github.mgramin.funny_microservices_sns.message_service;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.UUID;

@Document(collection = "message")
@ToString @Getter
public class Message {

    private String id;
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
