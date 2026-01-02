package com.EcommerceApp.InfinitCart.controller;

import com.EcommerceApp.InfinitCart.DTO.UserDTO;
import com.EcommerceApp.InfinitCart.model.User;
import com.EcommerceApp.InfinitCart.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @PostMapping("/addUser")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO){
        userService.registerUser(userDTO);
        return ResponseEntity.ok("User Added Successfully");
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable UUID userId ,  @RequestBody UserDTO userDTO){
        userService.updateUser(userId,userDTO);
        return ResponseEntity.ok("User Updated Successfully");
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") UUID userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("User Deleted Successfully");
    }

}
