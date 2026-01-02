package com.EcommerceApp.InfinitCart.DTO;

import java.util.UUID;

public class CartItemDTO {

    private UUID cartItemId;
    private UUID productId;
    private int quantity;

    public CartItemDTO() {
    }

    public CartItemDTO(UUID cartItemId, UUID productId, int quantity) {
        this.cartItemId = cartItemId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public UUID getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(UUID cartItemId) {
        this.cartItemId = cartItemId;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
