package com.learning.productservice.models;

import com.learning.productservice.dto.ProductResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private long id;
    private String title;

    private String description;
    private Double price;
    private String imageUrl;

    private Category category;


    public static ProductResponseDto toProductResponse(Product dto){
        ProductResponseDto product = new ProductResponseDto();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        //product.setCategory();
        product.setPrice(dto.getPrice());

        product.setCategory(dto.getCategory().toString());
        return  product;

    }

}
