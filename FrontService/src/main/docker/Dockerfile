FROM java:8
MAINTAINER Maxime Gaudin <gaudin.maxime@gmail.com>

ADD front-1.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'

COPY conf/application.properties application.properties

ENTRYPOINT ["java", "-jar", "/app.jar", "--spring.config.location=file:/application.properties"]
