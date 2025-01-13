package com.fviel.urlshortener.interfaces;
import jakarta.validation.constraints.NotBlank;

public interface UrlShorter {
    public String shortenUrl(@NotBlank String originalUrl);    
}
