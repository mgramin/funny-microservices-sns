FROM openjdk:8
VOLUME /tmp

RUN wget https://github.com/jwilder/dockerize/releases/download/v0.1.0/dockerize-linux-amd64-v0.1.0.tar.gz
RUN tar -C /usr/local/bin -xzvf dockerize-linux-amd64-v0.1.0.tar.gz

RUN sh -c 'mkdir message-service'
COPY message-service-0.0.1-SNAPSHOT.jar message-service/message-service.jar
RUN sh -c 'touch /message-service/message-service.jar'
ENV JAVA_OPTS=""
WORKDIR /message-service
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dloader.path='.' -jar ./message-service.jar" ]
MAINTAINER "mgramin@gmail.com"
