package com.agrolink.agrolink.service;

import com.agrolink.agrolink.model.WeatherAlert;
import com.agrolink.agrolink.repository.WeatherAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherAlertService {

    @Autowired
    private WeatherAlertRepository weatherAlertRepository;

    public List<WeatherAlert> getAllWeatherAlerts() {
        return weatherAlertRepository.findAll();
    }

    public List<WeatherAlert> getWeatherAlertsByRegion(String region) {
        return weatherAlertRepository.findByRegion(region);
    }

    public WeatherAlert createWeatherAlert(WeatherAlert weatherAlert) {
        return weatherAlertRepository.save(weatherAlert);
    }

    public WeatherAlert updateWeatherAlert(WeatherAlert weatherAlert) {
        return weatherAlertRepository.save(weatherAlert);
    }

    public void deleteWeatherAlert(Long id) {
        weatherAlertRepository.deleteById(id);
    }
}
