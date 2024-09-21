package com.agrolink.agrolink.repository;

import com.agrolink.agrolink.model.WeatherAlert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherAlertRepository extends JpaRepository<WeatherAlert, Long> {
    List<WeatherAlert> findByRegion(String region);
}
