package com.learning.productservice.controllers;

import com.learning.productservice.dto.ProductResponseDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/product")
    public  String getAllProducts(){
        return "Hello from Java";
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponseDto>  getProductById(@PathVariable("id") Long id){
        ProductResponseDto dummy = new ProductResponseDto();
        dummy.setId(7L);
        dummy.setTitle("amazon");

        ResponseEntity<ProductResponseDto> response =
                new ResponseEntity<>(dummy, HttpStatusCode.valueOf(202));
        return response;
    }
}
