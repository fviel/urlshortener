package com.fviel.urlshortener.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.fviel.urlshortener.entities.Url;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Url> redisTemplate;

    public Map<String, Url> getAllValues() {
        Set<String> keys = redisTemplate.keys("*"); // Fetch all keys
        Map<String, Url> allValues = new HashMap<>();
        if (keys != null) {
            for (String key : keys) {
                Url value = redisTemplate.opsForValue().get(key); // Get the value for each key
                allValues.put(key, value);
            }
        }
        return allValues;
    }

    public void clearCurrentDatabase() {        
        redisTemplate.getConnectionFactory()
                     .getConnection()
                     .serverCommands()
                     .flushDb();
    }
 
    public void clearAllDatabases() {
        redisTemplate.getConnectionFactory()
                     .getConnection()
                     .serverCommands()
                     .flushAll();
    }

    public void printAllValues(){
        Map<String, Url> mapAllValues = new HashMap<>();
        for (Map.Entry<String, Url> entry : mapAllValues.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }        
    }

    public boolean addUrl(Url url){
        try{
            if(url == null){
                return false;
            }
            redisTemplate.opsForValue().set(url.getOriginalUrl(), url);
            System.out.println("1 ### RedisService.addUrl() - objeto adicionado ao redis");
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Url getUrl(String key){       
        try{
            if(key == null){
                return new Url();
            }
            Url url = redisTemplate.opsForValue().get(key);
            // return redisTemplate.opsForValue().get(key);
            if(url != null){
                System.out.println("1 ### RedisService.getUrl() - objeto encontrado no redis:" + url);
                return url;
            }else{
                System.out.println("1 ### RedisService.getUrl() - falha ao pesquisar Url no redis");
                return new Url();
            }            
        }catch(Exception e){
            e.printStackTrace();
            return new Url();
        }
    }
}
