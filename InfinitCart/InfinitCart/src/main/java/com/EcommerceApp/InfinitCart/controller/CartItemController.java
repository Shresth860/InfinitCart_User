package com.EcommerceApp.InfinitCart.controller;

import com.EcommerceApp.InfinitCart.DTO.CartItemDTO;
import com.EcommerceApp.InfinitCart.model.cartItem;
import com.EcommerceApp.InfinitCart.service.CartItemService;
import com.EcommerceApp.InfinitCart.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/CartItem")
public class CartItemController {
    private final CartItemService cartItemService;
    private final CartService cartService;

    public CartItemController(CartItemService cartItemService, CartService cartService) {
        this.cartItemService = cartItemService;
        this.cartService = cartService;
    }

    @GetMapping()
    public ResponseEntity<List<CartItemDTO>> getAllItems(){
        List<CartItemDTO> items = cartItemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @PostMapping("/add/{cartId}")
    public ResponseEntity<CartItemDTO> addItem(
            @PathVariable("cartId") UUID cartId,
            @RequestBody CartItemDTO cartItemDTO
    ) {
        CartItemDTO savedItem = cartItemService.addItem(cartId, cartItemDTO);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

}
