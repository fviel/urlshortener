package com.fviel.urlshortener.controllers;

import java.util.Map;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fviel.urlshortener.config.AppProperties;
import com.fviel.urlshortener.entities.Url;
import com.fviel.urlshortener.services.RedisService;

@RestController
@RequestMapping(value = "/shorty/maintenance")
public class MaintenanceController {

    private final RedisService redisService;
    private final Environment environment;
    private AppProperties appProperties;

    public MaintenanceController(
        RedisService redisService, 
        Environment environment,
        AppProperties appProperties){
        this.redisService = redisService;
        this.environment = environment;
        this.appProperties = appProperties;
    }

    @RequestMapping(value = "/v1/ping", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");        
    }

    /**
     * Gets data from environment vars, like $JAVA_HOME
     * @return
     */
    @RequestMapping(value = "/v1/env", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getEnvironmentData() {
        String redisip = environment.getProperty("spring.redis.host");
        String java_home = environment.getProperty("java.home");
        return ResponseEntity.ok("Redis IP: " + redisip + " \nJAVA_HOME: " + java_home);        
    }

    /**
     * Gets data from application.yml
     * @return
     */
    @RequestMapping(value = "/v1/prop", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getApplicationPropertyData() {
        String props = appProperties.toString();
        return ResponseEntity.ok(props);
    }

    //@GetMapping("/v1/redis/all")
    @RequestMapping(value = "/v1/redis", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Url> getAllRedisData() {
        return redisService.getAllValues();
    }

    @RequestMapping(value = "/v1/redis", method = RequestMethod.DELETE)
    @ResponseBody
    public String clearAllDatabases() {
        redisService.clearAllDatabases();
        return "All Redis databases cleared.";
    }
}