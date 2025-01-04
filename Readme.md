# Shorty - A Spring Boot with Redis URL shortener


[![](https://img.shields.io/badge/Spring%20Boot-6DB33F.svg?style=for-the-badge&logo=Spring-Boot&logoColor=black)]()
[![](https://img.shields.io/badge/Redis-FF4438.svg?style=for-the-badge&logo=Redis&logoColor=black)]()
[![](https://img.shields.io/badge/Ubuntu-E95420.svg?style=for-the-badge&logo=Ubuntu&logoColor=black)]()
[![](https://img.shields.io/badge/Postman-FF6C37.svg?style=for-the-badge&logo=Postman&logoColor=black)]()
[![](https://img.shields.io/badge/Docker-2496ED.svg?style=for-the-badge&logo=Docker&logoColor=black)]()

## 📄Description
It's a simple URL shortener API, with endpoints to add and read URL's;

## 📊Libraries and tools used 
- OpenJDK 17 (https://openjdk.org/projects/jdk/17/)
- Spring Framework (https://spring.io/projects/spring-framework)
- Apache Maven 3.9.6 (https://maven.apache.org/index.html)
- Redis Community Edition 7.4.1 (https://redis.io/downloads/)
- Apache Tomcat 10.1.34 (https://tomcat.apache.org/)
- Postman (https://www.postman.com/)

## 🚀Compile
```
mvn clean install -Dspring.profiles.active=dev
```

## 🚀Run locally
```
mvn spring-boot:run
```

## 🐳Docker commands
```
docker compose up --build
```

## 🏆References
- [Docker HUB](https://hub.docker.com/)
- [Spring initializr](https://start.spring.io/);
- [Medium article - Create your own url shorteners with Spring Boot & Redis](https://medium.com/geekculture/create-your-own-url-shorteners-with-spring-boot-redis-289c9000f747)

