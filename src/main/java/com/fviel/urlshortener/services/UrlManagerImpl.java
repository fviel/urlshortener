package com.fviel.urlshortener.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.fviel.urlshortener.entities.Url;
import com.fviel.urlshortener.interfaces.UrlManager;
import jakarta.validation.constraints.NotBlank;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

@Service
@Primary //define que esta é a implementação primária desta interface
public class UrlManagerImpl implements UrlManager {

    /*
    @Autowired
    private RedisTemplate<String, Url> redisTemplate;
    */

    private final RedisService redisService;
    public UrlManagerImpl(RedisService redisService){
        this.redisService = redisService;
    }

    @Override
    public String getShortenUrlByOriginalUrl(@NotBlank String originalUrl) {
        try{

            System.out.println("UrlManagerImpl.getShortenUrlByOriginalUrl() - originalUrl recebida: [" + originalUrl +"]");            
            Url url = redisService.getUrl(originalUrl);
            System.out.println("UrlManagerImpl.getUrlByKey() - Url encontrada: [" + url +"]");
            return url.getShortenUrl();

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }        
    } 
          
    @Override
    public Url shortenUrl(@NotBlank String originalUrl) {
        // generating murmur3 based hash key as short URL
        String shortenUrl = Hashing.murmur3_128().hashString(originalUrl, StandardCharsets.UTF_8).toString();    
        System.out.println("1 ### UrlManagerImpl.shortenUrl() - originalUrl recebida :[" + originalUrl + "]");
        System.out.println("2 ### UrlManagerImpl.shortenUrl() - shortenUrl gerada:[" + originalUrl +"]");                   
        Url newUrl = new Url(originalUrl, shortenUrl);
        System.out.println("3 ### UrlManagerImpl.shortenUrl() - obj url gerado :[" + newUrl + "]");
        if(redisService.addUrl(newUrl)){
            System.out.println("4 ### UrlManagerImpl.shortenUrl() - objeto adicionado com sucesso no redis");
        }else{
            System.out.println("5 ### UrlManagerImpl.shortenUrl() - falha ao adicionar objeto no redis");
        }        
        return newUrl;
    }
}