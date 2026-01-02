package com.EcommerceApp.InfinitCart.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponseDTO {
    private String token;
    private String email;
    private String role;

}
