package com.example.weatherapi.controller;

import com.example.weatherapi.entity.WeatherPerHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.weatherapi.service.WeatherService;

import java.util.List;

@RestController
public class WeatherController {
    @Autowired
    private WeatherService service ;

    @GetMapping("/all")
    public List<WeatherPerHours> findAllWeathers() {
        return service.getWeathers();
    }
}
