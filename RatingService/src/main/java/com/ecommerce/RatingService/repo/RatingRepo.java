package com.ecommerce.RatingService.repo;

import com.ecommerce.RatingService.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

// must use mongo db
public interface RatingRepo extends MongoRepository<Rating, String>{
    List<Rating> findAllByUserId(String userId);

    List<Rating> findAllByProductId(String productId);
}
