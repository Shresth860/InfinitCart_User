package com.EcommerceApp.InfinitCart.DTO;

import com.EcommerceApp.InfinitCart.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ProductResponseDTO {

    private UUID productId;
    private String name;
    private double price;
    private int stock;
    private String description;

    public ProductResponseDTO toResponseDTO(Product product) {
        return new ProductResponseDTO(
                product.getProductId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getDescription()
        );
    }

}

// for User Read only