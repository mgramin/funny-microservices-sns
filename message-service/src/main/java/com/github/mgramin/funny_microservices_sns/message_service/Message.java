package com.github.mgramin.funny_microservices_sns.message_service;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@Table(value = "message")
@ToString @Getter @Data @NoArgsConstructor
public class Message {

    @PrimaryKeyColumn(name = "from_account", type = PrimaryKeyType.PARTITIONED)
    private UUID fromAccount;

    @PrimaryKeyColumn(name = "to_account", type = PrimaryKeyType.PARTITIONED)
    private UUID toAccount;

    @PrimaryKeyColumn(name = "time", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private Instant time;

    @Column("text")
    private String text;

    public Message(final UUID fromAccount, final UUID toAccount, final String text) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.text = text;
        this.time = Instant.now();
    }

}
