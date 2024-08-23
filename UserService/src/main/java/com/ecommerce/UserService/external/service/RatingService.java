package com.ecommerce.UserService.external.service;

import com.ecommerce.UserService.external.model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient("RATING-SERVICE")
public interface RatingService {
    @GetMapping("/api/v1/ratings/user/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable String userId);
}
