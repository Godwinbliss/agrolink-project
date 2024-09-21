package com.agrolink.agrolink.repository;

import com.agrolink.agrolink.model.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditScoreRepository extends JpaRepository<CreditScore, Long> {

    // Custom query method to find credit score by user ID
    CreditScore findByUserId(Long userId);
}
