package com.github.mgramin.funny_microservices_sns.web_client.client;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.util.UUID;

@ToString @Getter @Data @NoArgsConstructor
public class Message {

    private UUID fromAccount;

    private UUID toAccount;

    private Instant time;

    private String text;

    public Message(final UUID fromAccount, final UUID toAccount, final String text) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.text = text;
        this.time = Instant.now();
    }

}
