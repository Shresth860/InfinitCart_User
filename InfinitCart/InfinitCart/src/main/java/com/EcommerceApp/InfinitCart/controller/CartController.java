package com.EcommerceApp.InfinitCart.controller;

import com.EcommerceApp.InfinitCart.DTO.CartDTO;
import com.EcommerceApp.InfinitCart.model.Cart;
import com.EcommerceApp.InfinitCart.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // GET CART BY USER ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<CartDTO> getCartByUserId(@PathVariable UUID userId) {
        CartDTO cartDTO = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cartDTO);
    }

    // CREATE CART FOR USER
    @PostMapping("/user/{userId}")
    public ResponseEntity<CartDTO> createCart(@PathVariable UUID userId) {
        CartDTO cartDTO = cartService.addCart(userId);
        return ResponseEntity.status(201).body(cartDTO);
    }

    // UPDATE CART BY CART ID
    @PutMapping("/{cartId}")
    public ResponseEntity<CartDTO> updateCart(@PathVariable UUID cartId) {
        CartDTO updatedCart = cartService.updateCart(cartId);
        return ResponseEntity.ok(updatedCart);
    }

    // DELETE CART BY CART ID
    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable UUID cartId) {
        cartService.deleteCart(cartId);
        return ResponseEntity.noContent().build();
    }
}
