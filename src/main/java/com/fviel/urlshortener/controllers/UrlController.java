package com.fviel.urlshortener.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fviel.urlshortener.entities.Url;
import com.fviel.urlshortener.enums.ShorterAlgorithmEnum;
import com.fviel.urlshortener.interfaces.UrlManager;

@RestController
@RequestMapping(value = "/shorty/url")
public class UrlController {


    /*
    Funciona desta forma, mas não é indicado, o correto é fazer uso da construtora
    @Autowired
    private UrlManager urlManager;
    */

    private final UrlManager urlManager;
    public UrlController(UrlManager urlManager){
        this.urlManager = urlManager;
    }

    @RequestMapping(value = "/v1/{originalUrl}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> shortenUrl(@PathVariable String originalUrl) {
        Url shortUrlEntry = urlManager.addNewUrl(originalUrl, ShorterAlgorithmEnum.MURMUR3 );
        if (shortUrlEntry == null) {
            return ResponseEntity.status(500).body("Failed to shorten URL");
        }
        return ResponseEntity.ok(shortUrlEntry.toString());        
    }

    @RequestMapping(value = "/v1/{originalUrl}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getUrl(@PathVariable String originalUrl) {       
        if(originalUrl != null){
            String url = urlManager.getShortenUrlByOriginalUrl(originalUrl);
            return ResponseEntity.ok(url);
        }else{
            return ResponseEntity.status(404).body("Resource not found");
        }
    }

    @RequestMapping(value = "/v1/murmur/{originalUrl}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> shortenUrlMurmur(@PathVariable String originalUrl) {
        Url shortUrlEntry = urlManager.addNewUrl(originalUrl, ShorterAlgorithmEnum.MURMUR3 );
        if (shortUrlEntry == null) {
            return ResponseEntity.status(500).body("Failed to shorten URL");
        }
        return ResponseEntity.ok(shortUrlEntry.toString());        
    }

    @RequestMapping(value = "/v1/sha256/{originalUrl}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> shortenUrlSha256(@PathVariable String originalUrl) {
        Url shortUrlEntry = urlManager.addNewUrl(originalUrl, ShorterAlgorithmEnum.SHA256);
        if (shortUrlEntry == null) {
            return ResponseEntity.status(500).body("Failed to shorten URL");
        }
        return ResponseEntity.ok(shortUrlEntry.toString());        
    }

    @RequestMapping(value = "/v1/md5/{originalUrl}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> shortenUrlmd5(@PathVariable String originalUrl) {
        Url shortUrlEntry = urlManager.addNewUrl(originalUrl, ShorterAlgorithmEnum.MD5 );
        if (shortUrlEntry == null) {
            return ResponseEntity.status(500).body("Failed to shorten URL");
        }
        return ResponseEntity.ok(shortUrlEntry.toString());        
    }
}