package com.agrolink.agrolink.controller;
import com.agrolink.agrolink.model.MarketListing;
import com.agrolink.agrolink.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/market")
public class MarketController {

    @Autowired
    private MarketService marketService;

    @GetMapping("/listings")
    public ResponseEntity<List<MarketListing>> getAllMarketListings() {
        List<MarketListing> listings = marketService.getAllMarketListings();
        return ResponseEntity.ok(listings);
    }

    @GetMapping("/find")
    public ResponseEntity<List<MarketListing>> findByProductName(@RequestParam String productName) {
        List<MarketListing> listings = marketService.findByProductName(productName);
        return ResponseEntity.ok(listings);
    }

    @PostMapping("/create")
    public ResponseEntity<MarketListing> createMarketListing(@RequestBody MarketListing marketListing) {
        MarketListing newListing = marketService.createMarketListing(marketListing);
        return ResponseEntity.ok(newListing);
    }

    @PutMapping("/update")
    public ResponseEntity<MarketListing> updateMarketListing(@RequestBody MarketListing marketListing) {
        MarketListing updatedListing = marketService.updateMarketListing(marketListing);
        return ResponseEntity.ok(updatedListing);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMarketListing(@PathVariable Long id) {
        marketService.deleteMarketListing(id);
        return ResponseEntity.noContent().build();
    }
}
