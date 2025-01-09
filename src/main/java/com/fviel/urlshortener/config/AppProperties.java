package com.fviel.urlshortener.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    @Value("${spring.data.redis.host}")
    private String rhost;

    @Value("${spring.data.redis.port}")
    private String rport;

    @Value("${spring.data.redis.password}")
    private String rpwd;

    @Value("${app.name}")
    private String name;

    @Value("${app.version}")
    private String version;

    @Value("${app.author.name}")
    private String author_name;

    @Value("${app.author.email}")
    private String author_email;




    public String toString(){
        String resp =
        "application.yml{" +
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
