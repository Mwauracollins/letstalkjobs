FROM openjdk:19-oracle
ARG JAR_FILE=target/*.jar
COPY ./target/SimplifyInternships-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]