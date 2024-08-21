package com.ecommerce.RatingService.service;

import com.ecommerce.RatingService.model.Rating;

import java.util.List;

public interface IRatingService {
    public Rating saveRating(Rating rating);
    public Rating updateRating(Rating rating);
    public List<Rating> getAllRatings();
    public List<Rating> getRatingsByUserId(String userId);
    public List<Rating> getRatingsByProductId(String productId);
    public void deleteRating(String id);
}
