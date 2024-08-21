package com.ecommerce.RatingService.controller;

import com.ecommerce.RatingService.model.Rating;
import com.ecommerce.RatingService.service.impl.RatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public List<Rating> getAllRatings(){
        return ratingService.getAllRatings();
    }

    @GetMapping("/user/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable String userId){
        return ratingService.getRatingsByUserId(userId);
    }

    @GetMapping("/product/{productId}")
    public List<Rating> getRatingsByProductId(@PathVariable String productId){
        return ratingService.getRatingsByProductId(productId);
    }

    @PostMapping
    public Rating saveRating(@RequestBody Rating rating){
        return ratingService.saveRating(rating);
    }

    @PutMapping
    public Rating updateRating(@RequestBody Rating rating){
        return ratingService.updateRating(rating);
    }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable String id){
        ratingService.deleteRating(id);
    }
}
