package com.fviel.urlshortener.components;

import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Component;
import com.fviel.urlshortener.interfaces.UrlShorter;
import com.google.common.hash.Hashing;
import jakarta.validation.constraints.NotBlank;

/**
 * Following Liskov Substitution principle, Interface Segregation principle,
 * this class implements a concrete instance,by the algorithm MD5
 */
@Component
public class UrlShorterSha256 implements UrlShorter{

    @Override
    public String shortenUrl(@NotBlank String originalUrl) {
        // generating murmur3 based hash key as short URL
        String shortenUrl = Hashing.sha256().hashString(originalUrl, StandardCharsets.UTF_8).toString();             
        return shortenUrl;
    }
    
}





