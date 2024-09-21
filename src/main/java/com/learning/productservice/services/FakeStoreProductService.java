package com.learning.productservice.services;

import com.learning.productservice.dto.FakeStoreProductResponsedto;
import com.learning.productservice.models.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FakeStoreProductService implements ProductService  {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreProductResponsedto dto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductResponsedto.class
        );
        return dto.toProduct(dto);

    }

    public List<Product> getAllProduct(){
        List<FakeStoreProductResponsedto> dtos = restTemplate.exchange(

                "https://fakestoreapi.com/products" , HttpMethod.GET,null,
                new ParameterizedTypeReference<List<FakeStoreProductResponsedto>>() {}
        ).getBody();
        return dtos.stream()
                .map(dto -> dto.toProduct(dto))  // Convert each dto to a Product
                .collect(Collectors.toList());
    }


}
