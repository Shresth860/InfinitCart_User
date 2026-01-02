package com.EcommerceApp.InfinitCart.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Address_id", updatable = false, nullable = false)
    private UUID addressId;

    private String city;

    private String pincode;

    private String street;

    private String state;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;




}
