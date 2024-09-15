package com.ecommerce.RatingService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "user_ratings1")
public class Rating {
    @Id
    private String id;
    private String userId;
    private Long productId;
    private int rating;
    private String comment;
}
