package com.agrolink.agrolink.service;

import com.agrolink.agrolink.service.AgroAdviceService;
import com.agrolink.agrolink.service.CreditScoreService;
import com.agrolink.agrolink.service.MarketService;
import com.agrolink.agrolink.service.WeatherAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UssdService {

    private final CreditScoreService creditScoreService;

    private final MarketService marketService;

    private final WeatherAlertService weatherAlertService;

    private final AgroAdviceService agroAdviceService;

    public UssdService(CreditScoreService creditScoreService, MarketService marketService, WeatherAlertService weatherAlertService, AgroAdviceService agroAdviceService) {
        this.creditScoreService = creditScoreService;
        this.marketService = marketService;
        this.weatherAlertService = weatherAlertService;
        this.agroAdviceService = agroAdviceService;
    }

    public String processUssdInput(String sessionId, String phoneNumber, String text) {
        String[] userInput = text.split("\\*");
        String userResponse = "";

        if (text.equals("")) {
            // Initial menu
            userResponse = "CON Welcome to AgroService. Choose an option: \n" +
                    "1. Credit Scoring and Micro-loans \n" +
                    "2. Market Information Service \n" +
                    "3. Weather Alerts and Farming Tips \n" +
                    "4. Digital Marketplace \n" +
                    "5. Voice-based Agricultural Advisory";
        } else if (userInput[0].equals("1")) {
            // Credit Scoring and Micro-loans
            userResponse = "CON Enter your loan amount or choose 0 to go back.";
            if (userInput.length == 2) {
                String amount = userInput[1];
                // Call backend API to get credit score and micro-loan
                userResponse = creditScoreService.getCreditScoreAndLoanDetails(phoneNumber, amount);
            }
        } else if (userInput[0].equals("2")) {
            // Market Information Service
            userResponse = "CON Choose a product to view market prices: \n" +
                    "1. Rice \n" +
                    "2. Maize \n" +
                    "3. Beans";
            if (userInput.length == 2) {
                String product = userInput[1];
                // Call backend API to get market information
                userResponse = marketService.getMarketInfoByProduct(product);
            }
        } else if (userInput[0].equals("3")) {
            // Weather Alerts and Farming Tips
            userResponse = "CON Enter your region to get weather alerts:";
            if (userInput.length == 2) {
                String region = userInput[1];
                // Call backend API to get weather alerts
                userResponse = weatherAlertService.getWeatherAlertsByRegion(region).toString();
            }
        } else if (userInput[0].equals("4")) {
            // Digital Marketplace
            userResponse = "CON Enter the product you want to sell or search for:";
            if (userInput.length == 2) {
                String product = userInput[1];
                // Call backend API to interact with digital marketplace
                userResponse = marketService.addOrSearchProductInMarket(product);
            }
        } else if (userInput[0].equals("5")) {
            // Voice-based Agricultural Advisory
            userResponse = "CON Choose a language: \n" +
                    "1. English \n" +
                    "2. Hausa \n" +
                    "3. Igbo \n" +
                    "4. Yoruba";
            if (userInput.length == 2) {
                String language = userInput[1];
                // Call backend API for agro-advice based on the language
                userResponse = agroAdviceService.getAdviceByLanguage(language);
            }
        } else {
            // Invalid input or returning to the main menu
            userResponse = "CON Invalid choice. Please try again. \n" +
                    "1. Credit Scoring and Micro-loans \n" +
                    "2. Market Information Service \n" +
                    "3. Weather Alerts and Farming Tips \n" +
                    "4. Digital Marketplace \n" +
                    "5. Voice-based Agricultural Advisory";
        }

        return userResponse;
    }
}
