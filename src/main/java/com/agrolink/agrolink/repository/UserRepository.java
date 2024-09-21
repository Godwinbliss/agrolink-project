package com.agrolink.agrolink.repository;

import com.agrolink.agrolink.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query method to find user by phone number
    Optional<User> findByPhoneNumber(String phoneNumber);
}
