package com.fviel.urlshortener.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fviel.urlshortener.entities.Url;
import com.fviel.urlshortener.interfaces.UrlManager;

@RestController
@RequestMapping(value = "/urlShortener")
public class UrlController {

    @Autowired
    private UrlManager urlManager;

    @RequestMapping(value = "/{url}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> shortenUrl(@PathVariable String url) {
        Url shortUrlEntry = urlManager.shortenUrl(url);
        System.out.println("URL de entrada: " + url + "\nURL encurtada: " + shortUrlEntry.getUrl());
        return ResponseEntity.ok(url);
        
    }

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getUrl(@PathVariable String key) {
        String url = urlManager.getUrlByKey(key);
        return ResponseEntity.ok(url);
    }
}