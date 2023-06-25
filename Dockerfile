FROM openjdk:17
WORKDIR /app
ADD target/mailAuthentication-0.0.2.jar mailAuthentication-0.0.2.jar
ENTRYPOINT ["java", "-jar", "mailAuthentication-0.0.2.jar"]