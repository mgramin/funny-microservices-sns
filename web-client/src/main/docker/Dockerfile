FROM openjdk:8
VOLUME /tmp


RUN sh -c 'mkdir web-client'
COPY web-client-0.0.1-SNAPSHOT.jar web-client/web-client.jar
RUN sh -c 'touch /web-client/web-client.jar'
ENV JAVA_OPTS=""
WORKDIR /web-client
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dloader.path='.' -jar ./web-client.jar" ]
MAINTAINER "mgramin@gmail.com"
