package com.fviel.urlshortener.entities;

import java.time.LocalDateTime;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Url {  

    @NotBlank
    private String originalUrl;

    @NotNull
    private String shortenUrl;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;

    public Url(){
        this.createdAt = LocalDateTime.now();
    }

    public Url(String originalUrl, String shortenUrl){
        this.originalUrl = originalUrl;
        this.shortenUrl = shortenUrl;
        this.createdAt = LocalDateTime.now();  
    }

    public String getOriginalUrl(){
        return originalUrl;
    }   
    public void setOriginalUrl(String originalUrl){
        this.originalUrl = originalUrl;
    }   
    public String getShortenUrl(){
        return shortenUrl;
    }   

    public void setShortenUrl(String shortenUrl){
        this.shortenUrl = shortenUrl;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }   

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }   

    public String toString(){
        return "Url{\n" + 
        "originalUrl=" + originalUrl + ", \n" +
        "shortenUrl='" + shortenUrl + ", \n" +
        "createdAt=" + createdAt + ", \n" +
        "}";
    }   
}
