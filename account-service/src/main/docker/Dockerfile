FROM openjdk:8
VOLUME /tmp

RUN wget https://github.com/jwilder/dockerize/releases/download/v0.1.0/dockerize-linux-amd64-v0.1.0.tar.gz
RUN tar -C /usr/local/bin -xzvf dockerize-linux-amd64-v0.1.0.tar.gz

RUN sh -c 'mkdir account-service'
COPY account-service-0.0.1-SNAPSHOT.jar account-service/account-service.jar
RUN sh -c 'touch /account-service/account-service.jar'
ENV JAVA_OPTS=""
WORKDIR /account-service
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dloader.path='.' -jar ./account-service.jar" ]
MAINTAINER "mgramin@gmail.com"
