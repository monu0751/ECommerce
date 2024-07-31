package com.ecommerce.product.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/products/")
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "Test";
    }
}
