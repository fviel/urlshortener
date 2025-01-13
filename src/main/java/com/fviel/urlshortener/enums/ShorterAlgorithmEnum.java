package com.fviel.urlshortener.enums;

public enum ShorterAlgorithmEnum {
    MD5("md5"),
    SHA256("sha256"),
    MURMUR3("murmur3");

    private String algorithmName;

    private ShorterAlgorithmEnum(String algorithmName){
        this.algorithmName = algorithmName;
    }

    public String getAlgorithmName(){
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName){
        this.algorithmName = algorithmName;
    }

}
