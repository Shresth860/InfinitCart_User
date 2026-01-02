package com.EcommerceApp.InfinitCart.repository;

import com.EcommerceApp.InfinitCart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProductRepo extends JpaRepository<Product, UUID> {
//    void findByProduct_productId(UUID productId);
}
