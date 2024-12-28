package com.fviel.urlshortener.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fviel.urlshortener.entities.Url;
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

    @RequestMapping(value = "/v1/{fullurl}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> shortenUrl(@PathVariable String fullurl) {
        Url shortUrlEntry = urlManager.shortenUrl(fullurl);
        return ResponseEntity.ok(shortUrlEntry.toString());        
    }

    @RequestMapping(value = "/v1/{fullurl}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getUrl(@PathVariable String fullurl) {       
        if(fullurl != null){
            String url = urlManager.getShortenUrlByOriginalUrl(fullurl);
            return ResponseEntity.ok(url);
        }else{
            //corrigir isto
            return ResponseEntity.ok("falha");
        }
    }
}