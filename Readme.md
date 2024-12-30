# Shorty - A simples Spring Boot with Redis URL shortener

## Description
It's a simple URL shortener API, with endpoints to add and read URL's;

## Librarie/tools used 
- OpenJDK 17 (https://openjdk.org/projects/jdk/17/)
- Spring Framework (https://spring.io/projects/spring-framework)
- Apache Maven 3.9.6 (https://maven.apache.org/index.html)
- Redis Community Edition 7.4.1 (https://redis.io/downloads/)
- Apache Tomcat 10.1.34 (https://tomcat.apache.org/)
- Postman (https://www.postman.com/)

## Compile commands
```
mvn clean install -Dspring.profiles.active=dev
```

## Run locally commands
```
mvn spring-boot:run
```

## Docker commands
```
docker compose up --build
```

## References
- Docker HUB (https://hub.docker.com/)
- Spring initializr (https://start.spring.io/);
- Medium article - Create your own url shorteners with Spring Boot & Redis - (https://medium.com/geekculture/create-your-own-url-shorteners-with-spring-boot-redis-289c9000f747)

