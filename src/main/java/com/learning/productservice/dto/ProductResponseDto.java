package com.learning.productservice.dto;

import com.learning.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private long id;
    private String title;

    private String description;
    private Double price;
    private String imageUrl;

    private String category;
}
