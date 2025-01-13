package com.fviel.urlshortener.interfaces;

import com.fviel.urlshortener.entities.Url;
import com.fviel.urlshortener.enums.ShorterAlgorithmEnum;
import jakarta.validation.constraints.NotBlank;

public interface UrlManager {    
    public String getShortenUrlByOriginalUrl(@NotBlank String originalUrl);
    public Url addNewUrl(@NotBlank String originalUrl, ShorterAlgorithmEnum shorterAlg);
}
