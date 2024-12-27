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

    @NotNull
    private Integer key;

    @NotBlank
    private String url;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;

    public Url(){
        this.createdAt = LocalDateTime.now();
    }

    public Url(Integer key, String url){
        this.key = key;
        this.url = url;
        this.createdAt = LocalDateTime.now();  
    }

    public Integer getKey(){
        return key;
    }   
    public void setKey(Integer key){
        this.key = key;
    }   
    public String getUrl(){
        return url;
    }   

    public void setUrl(String url){
        this.url = url;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }   

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }   

    public String toString(){
        return "Url{" + "key=" + key + ", url='" + url + '\'' + ", createdAt=" + createdAt + '}';
    }   
}
