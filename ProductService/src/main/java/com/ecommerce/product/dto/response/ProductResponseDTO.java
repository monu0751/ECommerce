package com.ecommerce.product.dto.response;

import com.ecommerce.product.models.Category;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private Category category;
}
