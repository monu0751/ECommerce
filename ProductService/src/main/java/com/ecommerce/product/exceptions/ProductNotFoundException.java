package com.ecommerce.product.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String productNotFound) {
        super(productNotFound);
    }
}
