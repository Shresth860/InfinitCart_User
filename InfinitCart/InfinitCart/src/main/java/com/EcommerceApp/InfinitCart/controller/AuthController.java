package com.EcommerceApp.InfinitCart.controller;

import com.EcommerceApp.InfinitCart.DTO.AuthResponseDTO;
import com.EcommerceApp.InfinitCart.DTO.LoginDTO;
import com.EcommerceApp.InfinitCart.DTO.SignUpDTO;
import com.EcommerceApp.InfinitCart.model.User;
import com.EcommerceApp.InfinitCart.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@Valid @RequestBody SignUpDTO signUpDTO){
        return ResponseEntity.ok(authService.signup(signUpDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(authService.login(loginDTO));
    }
}
