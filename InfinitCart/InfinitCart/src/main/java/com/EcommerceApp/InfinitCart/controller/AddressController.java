package com.EcommerceApp.InfinitCart.controller;

import com.EcommerceApp.InfinitCart.DTO.AddressDTO;
import com.EcommerceApp.InfinitCart.model.Address;
import com.EcommerceApp.InfinitCart.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

//    @GetMapping()
//    public ResponseEntity<List<Address>> getAllAddress(){
//        return ResponseEntity.ok(addressService.getAllAddress());
//    }

    @GetMapping
    public ResponseEntity<List<AddressDTO>> getUserAddresses(
            @RequestParam UUID id) {

        return ResponseEntity.ok(addressService.getUserAddress(id));

    }


    @PostMapping("/addAddress")
    public ResponseEntity<Address> addAddress(  @RequestParam UUID id, @Valid @RequestBody Address address){
        Address savedAddress = addressService.addAddress(id,address);
        return ResponseEntity.status(201).body(savedAddress);
    }

    @PutMapping("/updateAddress/{addressId}")
    public ResponseEntity<String> updateAddress(@RequestAttribute UUID id,@PathVariable UUID addressId , @Valid @RequestBody Address address){
        addressService.updateAddress(id,addressId,address);
        return ResponseEntity.ok("Address Updated Successfully");
    }

    @DeleteMapping("/deleteAddress/{addressId}")
    public ResponseEntity<String> deleteAddress(
            @RequestAttribute(name = "id") UUID id,
            @PathVariable UUID addressId) {

        addressService.deleteAddress(id, addressId);
        return ResponseEntity.ok("Address deleted successfully");
    }


}
