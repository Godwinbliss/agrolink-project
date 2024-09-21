package com.agrolink.agrolink.service;

import com.agrolink.agrolink.model.CreditScore;
import com.agrolink.agrolink.repository.CreditScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditScoreService {

    @Autowired
    private CreditScoreRepository creditScoreRepository;

    public CreditScore getCreditScoreByUserId(Long userId) {
        return creditScoreRepository.findByUserId(userId);
    }

    public CreditScore createCreditScore(CreditScore creditScore) {
        return creditScoreRepository.save(creditScore);
    }

    public CreditScore updateCreditScore(CreditScore creditScore) {
        return creditScoreRepository.save(creditScore);
    }

    public void deleteCreditScore(Long id) {
        creditScoreRepository.deleteById(id);
    }

    public String getCreditScoreAndLoanDetails(String phoneNumber, String amount) {
        // Call REST API to calculate credit score based on the amount and user's phone number.
        // Return the result to the USSD response.
        return "END Your credit score is 720. You are eligible for a loan of $" + amount + ".";
    }
}
