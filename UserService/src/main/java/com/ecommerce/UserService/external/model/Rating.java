package com.ecommerce.UserService.external.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private String id;
    private String userId;
    private Long productId;
    private int rating;
    private String comment;
    private Product product;
}
