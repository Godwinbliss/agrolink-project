package com.agrolink.agrolink.controller;
import com.agrolink.agrolink.model.CreditScore;
import com.agrolink.agrolink.service.CreditScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/creditscore")
public class CreditScoreController {

    @Autowired
    private CreditScoreService creditScoreService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<CreditScore> getCreditScoreByUserId(@PathVariable Long userId) {
        CreditScore creditScore = creditScoreService.getCreditScoreByUserId(userId);
        return ResponseEntity.ok(creditScore);
    }

    @PostMapping("/create")
    public ResponseEntity<CreditScore> createCreditScore(@RequestBody CreditScore creditScore) {
        CreditScore newCreditScore = creditScoreService.createCreditScore(creditScore);
        return ResponseEntity.ok(newCreditScore);
    }

    @PutMapping("/update")
    public ResponseEntity<CreditScore> updateCreditScore(@RequestBody CreditScore creditScore) {
        CreditScore updatedCreditScore = creditScoreService.updateCreditScore(creditScore);
        return ResponseEntity.ok(updatedCreditScore);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCreditScore(@PathVariable Long id) {
        creditScoreService.deleteCreditScore(id);
        return ResponseEntity.noContent().build();
    }
}
