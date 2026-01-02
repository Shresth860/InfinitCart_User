package com.EcommerceApp.InfinitCart.service;
import com.EcommerceApp.InfinitCart.DTO.CartItemDTO;
import com.EcommerceApp.InfinitCart.model.Cart;
import com.EcommerceApp.InfinitCart.model.Product;
import com.EcommerceApp.InfinitCart.model.cartItem;
import com.EcommerceApp.InfinitCart.repository.CartItemRepo;
import com.EcommerceApp.InfinitCart.repository.CartRepo;
import com.EcommerceApp.InfinitCart.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartItemService {

    private final CartItemRepo cartItemRepo;
    private final CartRepo cartRepo;
    private final ProductRepo productRepo;

    public CartItemService(
            CartItemRepo cartItemRepo,
            CartRepo cartRepo,
            ProductRepo productRepo
    ) {
        this.cartItemRepo = cartItemRepo;
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }

    // GET ALL ITEMS
    public List<CartItemDTO> getAllItems() {
        return cartItemRepo.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // ADD ITEM TO CART
    public CartItemDTO addItem(UUID cartId, CartItemDTO cartItemDTO) {

        Cart cart = cartRepo.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Product product = productRepo.findById(cartItemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        cartItem cartItems = new cartItem();
        cartItems.setCart(cart);
        cartItems.setProduct(product);
        cartItems.setQuantity(cartItemDTO.getQuantity());

        cartItem savedItem = cartItemRepo.save(cartItems);

        return mapToDTO(savedItem);
    }

    // ENTITY → DTO
    private CartItemDTO mapToDTO(cartItem cartItem) {
        return new CartItemDTO(
                cartItem.getCartItemId(),
                cartItem.getProduct().getProductId(),
                cartItem.getQuantity()
        );
    }

}
