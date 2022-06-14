package com.example.weatherapi.service;

import com.example.weatherapi.entity.WeatherPerHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.weatherapi.repository.WeatherRepository;

import java.util.List;

@Service
public class WeatherService {
    @Autowired
    private WeatherRepository weatherRepository ;

    public WeatherPerHours saveWeather(WeatherPerHours weather) {
        return weatherRepository.save(weather);
    }

    public List<WeatherPerHours> getWeathers() {
        return weatherRepository.findAll();
    }
}
