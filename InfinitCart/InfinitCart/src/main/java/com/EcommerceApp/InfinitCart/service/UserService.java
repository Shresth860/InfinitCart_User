package com.EcommerceApp.InfinitCart.service;

import com.EcommerceApp.InfinitCart.DTO.UserDTO;
import com.EcommerceApp.InfinitCart.model.User;
import com.EcommerceApp.InfinitCart.repository.userRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final userRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(userRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserDTO userDTO) {
        User user = new User();

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setMobileNumber(userDTO.getMobileNumber());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(userDTO.getRole());
        userRepo.save(user);
    }

    public void updateUser(UUID userId, UserDTO userDTO) {
        User user = userRepo.findById(userId).orElseThrow(()->new RuntimeException("User Not found"));
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setMobileNumber(userDTO.getMobileNumber());

        // update password only if provided
        if (userDTO.getPassword() != null && !userDTO.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }

        userRepo.save(user);
    }



    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void deleteUser(UUID userId) {
       if(userRepo.existsById(userId)){
           userRepo.deleteById(userId);
       }else{
         throw  new RuntimeException("User not Found");
       }

    }
}
