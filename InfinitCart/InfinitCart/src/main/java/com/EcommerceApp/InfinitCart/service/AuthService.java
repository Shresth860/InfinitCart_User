package com.EcommerceApp.InfinitCart.service;

import com.EcommerceApp.InfinitCart.DTO.AuthResponseDTO;
import com.EcommerceApp.InfinitCart.DTO.LoginDTO;
import com.EcommerceApp.InfinitCart.DTO.SignUpDTO;
import com.EcommerceApp.InfinitCart.model.User;
import com.EcommerceApp.InfinitCart.repository.userRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final userRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(userRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ---------------- SIGNUP ----------------
    public User signup(@Valid SignUpDTO signUpDTO) {

        // Check if email already exists
        if (userRepository.existsByEmail(signUpDTO.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        User user = User.builder()
                .name(signUpDTO.getName())
                .email(signUpDTO.getEmail())
                .mobileNumber(signUpDTO.getMobileNumber())
                .password(passwordEncoder.encode(signUpDTO.getPassword()))
                .role("USER")
                .build();

        return userRepository.save(user);
    }

    // ---------------- LOGIN ----------------
    public AuthResponseDTO login(@Valid LoginDTO loginDTO) {

        User user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Password check
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return AuthResponseDTO.builder()
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
