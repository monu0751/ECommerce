package com.SpringSecurity.BasicAuthentication.controllers;

import com.SpringSecurity.BasicAuthentication.models.User;
import com.SpringSecurity.BasicAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveNewUser(user);
    }

    @GetMapping("/home")
    public  String home(){
        return "This is Home";
    }
}
