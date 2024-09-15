package com.ecommerce.redisCache.service;

import com.ecommerce.redisCache.model.Product;

import java.util.List;

public interface IRedisService {
    <T> T get(String key, Class<T> EntityClass);
    void set(String key, Object obj);

    List<Product> getProducts(String key);
    void setProducts(String key, List<Product> products);
}
