package com.EcommerceApp.InfinitCart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class cartItem {

    @Id
    @GeneratedValue
    private UUID cartItemId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;
}
