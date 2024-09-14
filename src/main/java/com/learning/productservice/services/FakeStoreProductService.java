package com.learning.productservice.services;

import com.learning.productservice.dto.FakeStoreProductResponsedto;
import com.learning.productservice.models.Product;
import org.springframework.web.client.RestTemplate;

public class FakeStoreProductService implements ProductService  {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreProductResponsedto dto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" +id,
                FakeStoreProductResponsedto.class
        );
        return dto.toProduct();

    }


}
