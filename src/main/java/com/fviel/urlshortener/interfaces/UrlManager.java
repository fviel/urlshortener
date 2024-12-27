package com.fviel.urlshortener.interfaces;

import com.fviel.urlshortener.entities.Url;

import jakarta.validation.constraints.NotBlank;


/**
 * Defins an generic interface to be respected for the concrete classes that will implement it.
 */
public interface UrlManager {    
    public String getUrlByKey(@NotBlank String key);
    public Url shortenUrl(@NotBlank String url);
}
