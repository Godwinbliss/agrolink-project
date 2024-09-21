package com.agrolink.agrolink.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CreditScore {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        private double farmSize;
        private double annualYield;
        private int creditScore;
}
