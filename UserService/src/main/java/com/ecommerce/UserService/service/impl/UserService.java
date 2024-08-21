package com.ecommerce.UserService.service.impl;

import com.ecommerce.UserService.exception.UserNotFoundException;
import com.ecommerce.UserService.model.User;
import com.ecommerce.UserService.repo.UserRepo;
import com.ecommerce.UserService.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
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
        return userRepo.findById(UUID.fromString(id)).orElseThrow(()-> new UserNotFoundException("User by id " + id + " was not found"));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User by email " + email + " was not found"));
    }

    @Override
    public void deleteUser(String id) {
        userRepo.deleteById(UUID.fromString(id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}
