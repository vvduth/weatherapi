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

    public List<WeatherPerHours> filterWeather(String query) {
        List<WeatherPerHours> filteredWeather = weatherRepository.loadedWeather(query);
        return  filteredWeather ;
    }

    public List<WeatherPerHours> getMaxTempInDay(String day, String month, String year) {
        List<WeatherPerHours> filteredWeather = weatherRepository.maxTempInDay(day, month, year);
        return  filteredWeather ;
    }

    public List<WeatherPerHours> getMinTempInDay(String day, String month, String year ) {
        List<WeatherPerHours> filteredWeater = weatherRepository.minTempInDay(day, month, year);
        return filteredWeater ;
    }
}
