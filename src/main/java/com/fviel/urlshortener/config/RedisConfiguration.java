
package com.fviel.urlshortener.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fviel.urlshortener.entities.Url;

/**
 * RedisTemplate bean to interact with Redis.
 * https://medium.com/geekculture/create-your-own-url-shorteners-with-spring-boot-redis-289c9000f747
 */
@Configuration
public class RedisConfiguration{

    @Bean
    public RedisTemplate<String, Url> redisTemplate(
        RedisConnectionFactory connectionFactory,
        ObjectMapper objectMapper) {
        final RedisTemplate<String, Url> redisTemplate = new RedisTemplate<>();
        Jackson2JsonRedisSerializer<Url> valueSerializer = new Jackson2JsonRedisSerializer<>(Url.class);
        //Jackson2JsonRedisSerializer valueSerializer = new Jackson2JsonRedisSerializer(Url.class);
        //valueSerializer.setObjectMapper(objectMapper);
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(valueSerializer);
        return redisTemplate;
    }
}