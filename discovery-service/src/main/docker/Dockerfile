FROM openjdk:8
VOLUME /tmp

RUN wget https://github.com/jwilder/dockerize/releases/download/v0.1.0/dockerize-linux-amd64-v0.1.0.tar.gz
RUN tar -C /usr/local/bin -xzvf dockerize-linux-amd64-v0.1.0.tar.gz

RUN sh -c 'mkdir discovery-service'
COPY discovery-service-0.0.1-SNAPSHOT.jar discovery-service/discovery-service.jar
RUN sh -c 'touch /discovery-service/discovery-service.jar'
ENV JAVA_OPTS=""
WORKDIR /discovery-service
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dloader.path='.' -jar ./discovery-service.jar" ]
MAINTAINER "mgramin@gmail.com"
