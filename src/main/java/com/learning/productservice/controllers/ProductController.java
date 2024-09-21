package com.learning.productservice.controllers;

import com.learning.productservice.dto.ProductResponseDto;
import com.learning.productservice.models.Product;
import com.learning.productservice.services.FakeStoreProductService;
import com.learning.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    @GetMapping("/product")
    public  List<ProductResponseDto> getAllProducts(){
        List<Product> products= this.productService.getAllProduct();
        return products.stream()
                .map(p -> p.toProductResponse(p))  // Convert each dto to a Product
                .collect(Collectors.toList());
    }
    private ProductService productService;
    @Autowired
    public ProductController(ProductService service){
        this.productService = service;
    }
    @GetMapping("/product/{id}")
    public ProductResponseDto getProductById(@PathVariable("id") Long id){

        Product product = this.productService.getProductById(1L);
        return product.toProductResponse(product);
//        ResponseEntity<ProductResponseDto> response =
//                new ResponseEntity<>(dummy, HttpStatusCode.valueOf(202));
//        return response;
    }
}
