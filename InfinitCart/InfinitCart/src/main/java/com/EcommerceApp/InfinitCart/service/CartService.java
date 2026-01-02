package com.EcommerceApp.InfinitCart.service;

import com.EcommerceApp.InfinitCart.DTO.CartDTO;
import com.EcommerceApp.InfinitCart.DTO.CartItemDTO;
import com.EcommerceApp.InfinitCart.model.Cart;
import com.EcommerceApp.InfinitCart.model.User;
import com.EcommerceApp.InfinitCart.repository.CartItemRepo;
import com.EcommerceApp.InfinitCart.repository.CartRepo;
import com.EcommerceApp.InfinitCart.repository.ProductRepo;
import com.EcommerceApp.InfinitCart.repository.userRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartService {

    private final CartRepo cartRepo;
    private final userRepository userRepo;

    public CartService(CartRepo cartRepo, userRepository userRepo) {
        this.cartRepo = cartRepo;
        this.userRepo = userRepo;
    }

    // GET CART BY CART ID
    public CartDTO getCartById(UUID cartId) {
        Cart cart = cartRepo.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        return mapToDTO(cart);
    }

    // GET CART BY USER ID
    public CartDTO getCartByUserId(UUID userId) {
        Cart cart = cartRepo.findByUser_UserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user"));

        return mapToDTO(cart);
    }

    // CREATE CART FOR USER
    public CartDTO addCart(UUID userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Optional: prevent duplicate carts
        Optional<Cart> existingCart = cartRepo.findByUser_UserId(userId);
        if (existingCart.isPresent()) {
            throw new RuntimeException("Cart already exists for this user");
        }

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setCartItems(new ArrayList<>());

        Cart savedCart = cartRepo.save(cart);
        return mapToDTO(savedCart);
    }

    // UPDATE CART (usually not needed, but kept for API completeness)
    public CartDTO updateCart(UUID cartId) {

        Cart cart = cartRepo.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        // No direct fields to update normally
        // Cart items are handled via CartItemService

        Cart updatedCart = cartRepo.save(cart);
        return mapToDTO(updatedCart);
    }

    // DELETE CART
    public void deleteCart(UUID cartId) {

        Cart cart = cartRepo.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        cartRepo.delete(cart);
    }

    // ENTITY → DTO MAPPING
    private CartDTO mapToDTO(Cart cart) {

        List<CartItemDTO> items = cart.getCartItems()
                .stream()
                .map(item -> new CartItemDTO(
                        item.getCartItemId(),
                        item.getProduct().getProductId(),
                        item.getQuantity()
                ))
                .toList();

        return new CartDTO(
                cart.getCartId(),
                cart.getUser().getUserId(),
                items
        );
    }
}
