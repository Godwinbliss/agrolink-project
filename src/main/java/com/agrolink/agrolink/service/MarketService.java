package com.agrolink.agrolink.service;

import com.agrolink.agrolink.model.MarketListing;
import com.agrolink.agrolink.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    @Autowired
    private MarketRepository marketRepository;

    public List<MarketListing> getAllMarketListings() {
        return marketRepository.findAll();
    }

    public List<MarketListing> findByProductName(String productName) {
        return marketRepository.findByProductName(productName);
    }

    public MarketListing createMarketListing(MarketListing marketListing) {
        return marketRepository.save(marketListing);
    }

    public MarketListing updateMarketListing(MarketListing marketListing) {
        return marketRepository.save(marketListing);
    }

    public void deleteMarketListing(Long id) {
        marketRepository.deleteById(id);
    }

    public String getMarketInfoByProduct(String productName) {
        // Call REST API to get market prices for the selected product
        // Return product prices to the USSD response.
        return "END Current market price for " + productName + " is $50 per bag.";
    }

    public String addOrSearchProductInMarket(String product) {
        // Call REST API to add a product to the digital marketplace or search for it
        return "END Product " + product + " has been added to the marketplace.";
    }
}
