package com.EcommerceApp.InfinitCart.controller;

//import com.EcommerceApp.InfinitCart.DTO.ProductRequestDTO;
import com.EcommerceApp.InfinitCart.DTO.ProductRequestDTO;
import com.EcommerceApp.InfinitCart.DTO.ProductResponseDTO;
import com.EcommerceApp.InfinitCart.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // View Product

    @GetMapping()
    public ResponseEntity<List<ProductResponseDTO>> getAllProduct(){
        List<ProductResponseDTO> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

    // Search Product By Their id
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable UUID productId){
        ProductResponseDTO product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(
            @RequestBody ProductRequestDTO dto) {

        return new ResponseEntity<>(
                productService.createProduct(dto),
                HttpStatus.CREATED
        );
    }

}
