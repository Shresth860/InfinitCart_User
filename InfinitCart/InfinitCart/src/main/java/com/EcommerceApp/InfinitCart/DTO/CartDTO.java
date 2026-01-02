package com.EcommerceApp.InfinitCart.DTO;

import java.util.List;
import java.util.UUID;

public class CartDTO {

    private UUID cartId;
    private UUID userId;
    private List<CartItemDTO> items;

    public CartDTO() {
    }

    public CartDTO(UUID cartId, UUID userId, List<CartItemDTO> items) {
        this.cartId = cartId;
        this.userId = userId;
        this.items = items;
    }

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public List<CartItemDTO> getItems() {
        return items;
    }

    public void setItems(List<CartItemDTO> items) {
        this.items = items;
    }
}
