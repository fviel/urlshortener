# Shorty - A simples Spring Boot with Redis URL shortener

## Description
It's a simple URL shortener API, with endpoints to add and read URL's;

## Compile commands
```
mvn clean install -Dspring.profiles.active=dev
```

## Run locally commands
```
mvn spring-boot:run
```

## Docker commands
docker network create app-network
docker run -d --name redis --network app-network redis:alpine
docker run -d --name spring-app --network app-network -e SPRING_REDIS_HOST=redis -e

## References 
[Medium article] (https://medium.com/geekculture/create-your-own-url-shorteners-with-spring-boot-redis-289c9000f747)

