package com.EcommerceApp.InfinitCart.service;

import com.EcommerceApp.InfinitCart.DTO.ProductRequestDTO;
import com.EcommerceApp.InfinitCart.DTO.ProductResponseDTO;
import com.EcommerceApp.InfinitCart.model.Product;
import com.EcommerceApp.InfinitCart.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    // ✅ Get all products
    public List<ProductResponseDTO> getAllProduct() {
        return productRepo.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // ✅ Get product by ID
    public ProductResponseDTO getProductById(UUID productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return toResponseDTO(product);
    }

    // ✅ Entity → DTO mapper
    private ProductResponseDTO toResponseDTO(Product product) {
        return new ProductResponseDTO(
                product.getProductId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getDescription()
        );
    }

    public ProductResponseDTO createProduct(ProductRequestDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setDescription(dto.getDescription());

        Product saved = productRepo.save(product);

        return toResponseDTO(saved);
    }
}
