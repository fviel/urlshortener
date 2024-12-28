package com.fviel.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fviel.urlshortener.entities.Url;
import com.fviel.urlshortener.interfaces.UrlManager;
import jakarta.validation.constraints.NotBlank;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

@Service
public class UrlManagerImpl implements UrlManager {
    @Autowired
    private RedisTemplate<String, Url> redisTemplate;

    @Override
    public String getUrlByKey(@NotBlank String key) {
        Url url = redisTemplate.opsForValue().get(key);
        return url.getUrl();
    }
    
    /**
     * Converte uma url String em uma chave Integer
     * Podia ser String? Podia...
     */
    @Override
    public Url shortenUrl(@NotBlank String url) {
        // generating murmur3 based hash key as short URL
        Integer key = Hashing.murmur3_128().hashString(url, StandardCharsets.UTF_8).asInt();       
        Url newUrl = new Url(key, url);
        return newUrl;
    }
}