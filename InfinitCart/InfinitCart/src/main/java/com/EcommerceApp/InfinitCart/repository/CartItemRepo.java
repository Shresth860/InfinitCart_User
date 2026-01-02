package com.EcommerceApp.InfinitCart.repository;

import com.EcommerceApp.InfinitCart.model.cartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CartItemRepo extends JpaRepository<cartItem, UUID> {
}
