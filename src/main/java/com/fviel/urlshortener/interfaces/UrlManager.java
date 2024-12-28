package com.fviel.urlshortener.interfaces;

import com.fviel.urlshortener.entities.Url;
import jakarta.validation.constraints.NotBlank;

public interface UrlManager {    
    public String getShortenUrlByOriginalUrl(@NotBlank String originalUrl);    
    public Url shortenUrl(@NotBlank String url);
}
