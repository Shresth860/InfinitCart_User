package com.EcommerceApp.InfinitCart.service;

import com.EcommerceApp.InfinitCart.DTO.AddressDTO;
import com.EcommerceApp.InfinitCart.model.Address;
import com.EcommerceApp.InfinitCart.repository.AddressRepo;
import com.EcommerceApp.InfinitCart.repository.userRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {

    private final AddressRepo addressRepository;
    private final userRepository userRepo;

    public AddressService(AddressRepo addressRepository, userRepository userRepo) {
        this.addressRepository = addressRepository;
        this.userRepo = userRepo;
    }

    // USER - Add Address
    public Address addAddress(UUID id, Address address) {

        var user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Address newAddress = new Address();
        newAddress.setCity(address.getCity());
        newAddress.setPincode(address.getPincode());
        newAddress.setState(address.getState());
        newAddress.setStreet(address.getStreet());
        newAddress.setUser(user);

        return addressRepository.save(newAddress);
    }

    // USER - Update Address (Ownership check)
    public void updateAddress(UUID id, UUID addressId, Address address) {

        Address existing = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        if (!existing.getUser().getUserId().equals(id)) {
            throw new RuntimeException("You are not allowed to update this address");
        }

        existing.setCity(address.getCity());
        existing.setPincode(address.getPincode());
        existing.setState(address.getState());
        existing.setStreet(address.getStreet());

        addressRepository.save(existing);
    }

    // USER - Delete Address (Ownership check)
    public void deleteAddress(UUID id, UUID addressId) {

        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        if (!address.getUser().getUserId().equals(id)) {
            throw new RuntimeException("You are not allowed to delete this address");
        }

        addressRepository.delete(address);
    }

    // USER - Get Own Addresses
    public List<AddressDTO> getUserAddress(UUID id) {
        return addressRepository.findByUser_UserId(id)
                .stream()
                .map(address -> {
                    AddressDTO dto = new AddressDTO();
                    dto.setAddressId(address.getAddressId());
                    dto.setStreet(address.getStreet());
                    dto.setCity(address.getCity());
                    dto.setState(address.getState());
                    dto.setPincode(address.getPincode());
                    return dto;
                })
                .toList();

    }

    // ADMIN - Get All Addresses
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }
}
