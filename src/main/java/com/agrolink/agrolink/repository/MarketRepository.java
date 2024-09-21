package com.agrolink.agrolink.repository;

import com.agrolink.agrolink.model.MarketListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRepository extends JpaRepository<MarketListing, Long> {

    // Find all market listings by product name
    List<MarketListing> findByProductName(String productName);
}
