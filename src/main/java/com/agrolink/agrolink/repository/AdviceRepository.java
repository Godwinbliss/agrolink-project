package com.agrolink.agrolink.repository;

import com.agrolink.agrolink.model.AgroAdvice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdviceRepository extends JpaRepository<AgroAdvice, Long> {
    List<AgroAdvice> findByLanguage(String language);
}
