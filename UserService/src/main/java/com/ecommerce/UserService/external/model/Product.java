package com.ecommerce.UserService.external.model;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    private Long categoryId;
}

