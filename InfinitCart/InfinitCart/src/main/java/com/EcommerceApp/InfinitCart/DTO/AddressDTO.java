package com.EcommerceApp.InfinitCart.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AddressDTO {

    private UUID addressId;

    private String city;

    private String pincode;

    private String street;

    private String state;
}
