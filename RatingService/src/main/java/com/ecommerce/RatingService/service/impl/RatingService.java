package com.ecommerce.RatingService.service.impl;

import com.ecommerce.RatingService.model.Rating;
import com.ecommerce.RatingService.repo.RatingRepo;
import com.ecommerce.RatingService.service.IRatingService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingService implements IRatingService {
    private final RatingRepo ratingRepo;

    public RatingService(RatingRepo ratingRepo) {
        this.ratingRepo = ratingRepo;
    }

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public Rating updateRating(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepo.findAllByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByProductId(String productId) {
        return ratingRepo.findAllByProductId(productId);
    }

    @Override
    public void deleteRating(String id) {

    }
}
