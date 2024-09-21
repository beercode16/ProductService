package com.learning.productservice.dto;

import com.learning.productservice.models.Category;
import com.learning.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponsedto {
    private long  id;
    private String title;
    private Double price;
    private String description;
    private String category;

    private String image;

    public static Product toProduct(FakeStoreProductResponsedto dto){
        Product product = new Product();
        product.setId(dto.id);
        product.setTitle(dto.title);
        //product.setCategory();
        product.setPrice(dto.price);

        Category cat = new Category();
        cat.setId(1);
        cat.setName(dto.category);
        product.setCategory(cat);
        return  product;

    }
}
