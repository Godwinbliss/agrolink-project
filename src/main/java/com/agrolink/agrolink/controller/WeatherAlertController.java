package com.agrolink.agrolink.controller;
import com.agrolink.agrolink.model.WeatherAlert;
import com.agrolink.agrolink.service.WeatherAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherAlertController {

    @Autowired
    private WeatherAlertService weatherAlertService;

    @GetMapping("/alerts")
    public ResponseEntity<List<WeatherAlert>> getAllWeatherAlerts() {
        List<WeatherAlert> alerts = weatherAlertService.getAllWeatherAlerts();
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/alerts/region")
    public ResponseEntity<List<WeatherAlert>> getWeatherAlertsByRegion(@RequestParam String region) {
        List<WeatherAlert> alerts = weatherAlertService.getWeatherAlertsByRegion(region);
        return ResponseEntity.ok(alerts);
    }

    @PostMapping("/create")
    public ResponseEntity<WeatherAlert> createWeatherAlert(@RequestBody WeatherAlert weatherAlert) {
        WeatherAlert newAlert = weatherAlertService.createWeatherAlert(weatherAlert);
        return ResponseEntity.ok(newAlert);
    }

    @PutMapping("/update")
    public ResponseEntity<WeatherAlert> updateWeatherAlert(@RequestBody WeatherAlert weatherAlert) {
        WeatherAlert updatedAlert = weatherAlertService.updateWeatherAlert(weatherAlert);
        return ResponseEntity.ok(updatedAlert);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWeatherAlert(@PathVariable Long id) {
        weatherAlertService.deleteWeatherAlert(id);
        return ResponseEntity.noContent().build();
    }
}

