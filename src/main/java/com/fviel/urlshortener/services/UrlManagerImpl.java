package com.fviel.urlshortener.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.fviel.urlshortener.components.UrlShorterMD5;
import com.fviel.urlshortener.components.UrlShorterMurmur3;
import com.fviel.urlshortener.components.UrlShorterSha256;
import com.fviel.urlshortener.entities.Url;
import com.fviel.urlshortener.enums.ShorterAlgorithmEnum;
import com.fviel.urlshortener.interfaces.UrlManager;
import com.fviel.urlshortener.interfaces.UrlShorter;
import jakarta.validation.constraints.NotBlank;

@Service
@Primary //defines this class at the primary concrete implementation of the interface
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
    public Url addNewUrl(@NotBlank String originalUrl, ShorterAlgorithmEnum shorterAlg) {
        Url url = createUrl(originalUrl, shorterAlg);
        persist(url);
        return url;
    }

    /**
     Applying Liskov, shorten a url by the selected algorithm
     * @param originalUrl
     * @return
     */
    private Url createUrl(@NotBlank String originalUrl, ShorterAlgorithmEnum shorterAlg){           
        UrlShorter urlShorter;
        String shortenUrl;
        switch(shorterAlg){
            case MD5:{
                urlShorter = new UrlShorterMD5();                
                break;
            }
            case MURMUR3:{
                urlShorter = new UrlShorterMurmur3();
                break;
            }
            case SHA256:{
                urlShorter = new UrlShorterSha256();
                break;
            }
            default:{
                urlShorter = new UrlShorterMurmur3();
            }
        }
        
        shortenUrl = urlShorter.shortenUrl(originalUrl);
        Url newUrl = new Url(originalUrl, shortenUrl);
        return newUrl;
    }

    private void persist(Url url){
        if(redisService.addUrl(url)){
            System.out.println("### UrlManagerImpl.persist() - Succesfully added the Url Object at Redis - " + url.getShortenUrl());
        }else{
            System.out.println("### UrlManagerImpl.persist() - Fail when adding the Url at Redis");
        }   
    }        
}