package com.ecommerce.UserService.service.impl;

import com.ecommerce.UserService.exception.UserNotFoundException;
import com.ecommerce.UserService.external.model.Product;
import com.ecommerce.UserService.external.service.ProductService;
import com.ecommerce.UserService.external.service.RatingService;
import com.ecommerce.UserService.external.model.Rating;
import com.ecommerce.UserService.model.User;
import com.ecommerce.UserService.repo.UserRepo;
import com.ecommerce.UserService.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    private final UserRepo userRepo;
    private final RatingService ratingService;
    private final ProductService productService;
    private final RestTemplate restTemplate;

    public UserService(UserRepo userRepo, RatingService ratingService, ProductService productService, RestTemplate restTemplate) {
        this.userRepo = userRepo;
        this.ratingService = ratingService;
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {
        user.setId(UUID.randomUUID());
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getUserById(String id) {

        User user = userRepo.findById(UUID.fromString(id)).orElseThrow(()-> new UserNotFoundException("User by id " + id + " was not found"));

        setProductInRating(user);
        return user;

        // below function using resttemplate static url for getting ratings of given user;

//        Rating[] ratings = restTemplate
//                .getForObject("http://localhost:8086/api/v1/ratings/user/" +
//                        user.getId(), Rating[].class);


        // below i have used @LoadBalnced with restTemplate bean in MyConfig class for using eureka server to get ratings of given user;
//        Rating[] ratings = restTemplate
//        .getForObject("http://RATING-SERVICE/api/v1/ratings/user/" +
//                user.getId(), Rating[].class);
//        List<Rating> ratingList = ratings != null ? List.of(ratings) : null;
//        user.setRatings(ratingList);
//        return user;



    }

    @Override
    public User getUserByEmail(String email) {
        User user = userRepo.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User by email " + email + " was not found"));
        setProductInRating(user);
        return user;
    }

    @Override
    public void deleteUser(String id) {
        userRepo.deleteById(UUID.fromString(id));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();
        for (User user : users) {
            setProductInRating(user);
        }
        return users;
    }

    private void setProductInRating(User user) {
        List<Rating> ratings = ratingService.getRatingsByUserId(user.getId().toString());
        List<Rating> ratingWithProducts =
                ratings.stream().map(rating -> {
                    Product product = productService.getProductById(rating.getProductId());
                    rating.setProduct(product);
                    return rating;
                }).toList();
        user.setRatings(ratingWithProducts);
    }

}
