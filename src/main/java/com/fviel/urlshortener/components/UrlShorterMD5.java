package com.fviel.urlshortener.components;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.springframework.stereotype.Component;

import com.fviel.urlshortener.interfaces.UrlShorter;
import com.google.common.hash.Hashing;

import jakarta.validation.constraints.NotBlank;

/**
 * Following Liskov Substitution principle, Interface Segregation principle,
 * this class implements a concrete instance,by the algorithm MD5
 */
@Component
public class UrlShorterMD5 implements UrlShorter{    
@Override
    public String shortenUrl(@NotBlank String originalUrl) {
        /*
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(longURL.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int index = Math.abs(digest[i] % CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        String shortURL = sb.toString();
        */

        String shortenUrl = Hashing.md5().hashString(originalUrl, StandardCharsets.UTF_8).toString();             
        return shortenUrl;
    }
}
