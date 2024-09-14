package com.learning.productservice.services;

import com.learning.productservice.dto.FakeStoreProductResponsedto;
import com.learning.productservice.models.Product;

public interface ProductService {
    public Product getProductById(Long id);
}
