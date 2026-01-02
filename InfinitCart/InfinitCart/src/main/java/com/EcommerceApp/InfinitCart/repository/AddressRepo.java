package com.EcommerceApp.InfinitCart.repository;

import com.EcommerceApp.InfinitCart.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AddressRepo extends JpaRepository<Address, UUID> {
//    List<Address> findByUserId(UUID userId);

    List<Address>findByUser_UserId(UUID UserId);
}
