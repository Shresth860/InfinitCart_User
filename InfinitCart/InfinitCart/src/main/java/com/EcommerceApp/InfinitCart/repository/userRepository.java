package com.EcommerceApp.InfinitCart.repository;

import com.EcommerceApp.InfinitCart.model.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import java.lang.ScopedValue;
//import java.lang.ScopedValue;
//import java.lang.ScopedValue;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface userRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(@Email String email);

    Optional<User> findByEmail(@Email String email);


}
