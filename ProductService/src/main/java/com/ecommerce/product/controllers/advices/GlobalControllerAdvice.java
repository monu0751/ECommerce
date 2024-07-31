package com.ecommerce.product.controllers.advices;

import com.ecommerce.product.dto.response.ExceptionResponseDTO;
import com.ecommerce.product.exceptions.CategoryNotFoundException;
import com.ecommerce.product.exceptions.ProductNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public ExceptionResponseDTO handleProductNotFoundException(ProductNotFoundException e){
        return ExceptionResponseDTO.builder()
                .message(e.getMessage())
                .details("Product not found")
                .statusCode("404")
                .build();
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ExceptionResponseDTO handleCategoryNotFoundException(CategoryNotFoundException e){
        return ExceptionResponseDTO.builder()
                .message(e.getMessage())
                .details("Category not found")
                .statusCode("404")
                .build();
    }
}
