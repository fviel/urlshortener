package com.fviel.urlshortener.controllers;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fviel.urlshortener.entities.Url;
import com.fviel.urlshortener.services.RedisService;

@RestController
@RequestMapping(value = "/shorty/maintenance")
public class MaintenanceController {

    private final RedisService redisService;
    public MaintenanceController(RedisService redisService){
        this.redisService = redisService;
    }

    @RequestMapping(value = "/v1/ping", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");        
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