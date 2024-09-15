package com.ecommerce.redisCache.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product{
    private Long id;
    private String name;
    private String description;
    private double price;
    private Long categoryId;
}
