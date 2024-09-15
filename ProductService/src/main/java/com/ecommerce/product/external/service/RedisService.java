package com.ecommerce.product.external.service;

import com.ecommerce.product.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("REDIS-CACHE")
public interface RedisService {
    @GetMapping("/api/v1/redis/getProducts/{key}")
    List<Product> getMostRatedProducts(@PathVariable String key);
}
