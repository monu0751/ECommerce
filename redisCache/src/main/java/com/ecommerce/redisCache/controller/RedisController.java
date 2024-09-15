package com.ecommerce.redisCache.controller;

import com.ecommerce.redisCache.model.Product;
import com.ecommerce.redisCache.service.IRedisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisController {
    private final IRedisService redisService;

    public RedisController(IRedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/get/{key}")
    public Product get(@PathVariable String key){
        return redisService.get(key, Product.class);
    }

    @PostMapping("/set/{key}")
    public void set(@PathVariable String key, @RequestBody Product product){
        redisService.set(key, product);
    }

    @GetMapping("/getProducts/{key}")
    public List<Product> getProducts(@PathVariable String key){
        return redisService.getProducts(key);
    }

    @PostMapping("/setProducts/{key}")
    public void setProducts(@PathVariable String key, @RequestBody List<Product> products){
        redisService.setProducts(key, products);

    }


}
