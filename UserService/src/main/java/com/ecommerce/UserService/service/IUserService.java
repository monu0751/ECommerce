package com.ecommerce.UserService.service;

import com.ecommerce.UserService.model.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    public User saveUser(User user);
    public User updateUser(User user);
    public User getUserById(String id);
    public User getUserByEmail(String email);
    public void deleteUser(String id);
    public List<User> getAllUsers();
}
