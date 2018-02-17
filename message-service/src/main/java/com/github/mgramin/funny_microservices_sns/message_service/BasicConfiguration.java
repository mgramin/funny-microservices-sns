package com.github.mgramin.funny_microservices_sns.message_service;

import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Collections;
import java.util.List;

//@Configuration
//@EnableAutoConfiguration
class BasicConfiguration {

    @Configuration
    @EnableCassandraRepositories
    static class CassandraConfig extends AbstractCassandraConfiguration {

        @Value("${cassandra.port}")
        int port;

        @Value("${cassandra.host}")
        String host;

        @Bean
        public CassandraTemplate cassandraTemplate(Session session) {
            return new CassandraTemplate(session);
        }


        @Override
        public int getPort() {
            return port;
        }

        @Override
        public String getContactPoints() {
            return host;
        }

        @Override
        public String getKeyspaceName() {
            return "example";
        }


        @Override
        protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
            return Collections.singletonList(CreateKeyspaceSpecification.createKeyspace(getKeyspaceName())
                    .ifNotExists()
                    .with(KeyspaceOption.DURABLE_WRITES, true)
                    .withSimpleReplication());
        }


        @Override
        public String[] getEntityBasePackages() {
            return new String[] {
                    Message.class.getPackage().getName()
            };
        }

        @Override
        public SchemaAction getSchemaAction() {
            return SchemaAction.RECREATE;
        }
    }

}
