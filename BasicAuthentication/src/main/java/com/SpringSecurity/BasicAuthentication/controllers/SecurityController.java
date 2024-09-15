package com.SpringSecurity.BasicAuthentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class SecurityController {

    @GetMapping("/home")
    public  String home(){
        return "This is Home";
    }
    @GetMapping("/student")
    public  String student(){
        return "This is Student";
    }
    @GetMapping("/admin")
    public  String admin(){
        return "This is Admin";
    }
    @PostMapping("/create")
    public String create(@RequestParam("username") String username, @RequestParam("password") String password){
//        return  userService.create(username, password);
        return "User Created";
    }
}
