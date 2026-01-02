package com.EcommerceApp.InfinitCart.DTO;

import com.EcommerceApp.InfinitCart.model.Product;
import lombok.Data;

@Data
public class ProductRequestDTO {

    private String name;
    private double price;
    private int stock;
    private String description;

    public Product toEntity(ProductRequestDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setDescription(dto.getDescription());
        return product;
    }

}

// for CRUD operation of admin