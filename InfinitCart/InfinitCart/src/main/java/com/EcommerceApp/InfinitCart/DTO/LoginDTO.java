package com.EcommerceApp.InfinitCart.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class LoginDTO {

    @Email
    private String email;
    @NotBlank
    private String password;

}
