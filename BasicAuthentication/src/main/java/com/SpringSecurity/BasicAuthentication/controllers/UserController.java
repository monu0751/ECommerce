package com.SpringSecurity.BasicAuthentication.controllers;

import com.SpringSecurity.BasicAuthentication.models.User;
import com.SpringSecurity.BasicAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PutMapping
    public User UpdateUser(User user){
        return userService.saveNewUser(user);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username){
        return userService.findByUserName(username);
    }
    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAll();
    }
}
