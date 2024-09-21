package com.learning.productservice.services;

import com.learning.productservice.dto.FakeStoreProductResponsedto;
import com.learning.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    public Product getProductById(Long id);

    public List<Product> getAllProduct();
}
