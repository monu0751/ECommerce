package com.ecommerce.redisCache.service.impl;

import com.ecommerce.redisCache.model.Product;
import com.ecommerce.redisCache.service.IRedisService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RedisService implements IRedisService {
    private final RedisTemplate<String, String> redisTemplate;

    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @Override
    public <T> T get(String key, Class<T> EntityClass){
        String s = redisTemplate.opsForValue().get(key);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(s, EntityClass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void set(String key, Object obj){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(obj);
            redisTemplate.opsForValue().set(key, s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getProducts(String key) {
        Long size = redisTemplate.opsForList().size(key);
        List<String> productListString = redisTemplate.opsForList().range(key, 0, size-1);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> productList = Objects.requireNonNull(productListString).stream().map(s -> {
            try{
                return objectMapper.readValue(s, Product.class);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }).toList();

        return productList;
    }

    @Override
    public void setProducts(String key, List<Product> products) {
        redisTemplate.opsForList().rightPushAll(key, products.stream().map(product -> {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.writeValueAsString(product);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }).toList());
    }
}
