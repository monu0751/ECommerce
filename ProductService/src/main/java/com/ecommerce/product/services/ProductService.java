package com.ecommerce.product.services;

import com.ecommerce.product.dto.request.ProductRequestDTO;
import com.ecommerce.product.dto.response.ProductResponseDTO;
import com.ecommerce.product.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    public ProductResponseDTO getProductById(Long id) throws ProductNotFoundException;
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) throws ProductNotFoundException;
    public void deleteProduct(Long id) throws ProductNotFoundException;
    public List<ProductResponseDTO> searchProduct(String name);
    public List<ProductResponseDTO> getAllProductsByCategory(Long categoryId);
}
