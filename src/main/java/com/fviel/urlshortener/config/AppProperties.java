package com.fviel.urlshortener.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    @Value("${spring.redis.test}")
    private String rtest;

    @Value("${spring.redis.host}")
    private String rhost;

    @Value("${spring.redis.port}")
    private String rport;

    @Value("${spring.redis.password}")
    private String rpwd;

    @Value("${app.name}")
    private String name;

    @Value("${app.version}")
    private String version;

    @Value("${app.author.name}")
    private String author_name;

    @Value("${app.author.email}")
    private String author_email;



/*
 ---
spring:
  redis:
    test: profile-default
    host: redis
    port: 6379
    password: null
app:
  name: shorty-dev
  version: 1.0.0
  author:
    name: Fernando Viel
    email: fviel1982@gmail.com
 */


    public String toString(){
        String resp =
        "application.yml{" +
            "\nspring.redis.test: " + rtest + 
            "\nspring.redis.host: " + rhost + 
            "\nspring.redis.port: " + rport +
            "\nspring.redis.password " + rpwd +

            "\napp.name: " + name + 
            "\napp.version: " + version + 
            "\napp.author.name: " + name +
            "\napp.author.email: " + version +
            "\n}";   
        return resp;
    }
    
}
