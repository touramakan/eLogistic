FROM openjdk:8-jdk
ADD target/eLogistic-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://data-container/test", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]