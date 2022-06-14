package com.example.weatherapi.controller;

import com.example.weatherapi.entity.WeatherPerHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.weatherapi.service.WeatherService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    @Autowired
    private WeatherService service ;

    @GetMapping("/all")
    public List<WeatherPerHours> findAllWeathers() {
        return service.getWeathers();
    }

    @GetMapping("/year")
    public ResponseEntity<List<WeatherPerHours>> filterWeather(@RequestParam("query") String query) {
        return  ResponseEntity.ok(service.filterWeather(query));
    }

    @GetMapping("/max/date")
    public ResponseEntity<List<WeatherPerHours>> filterMaxTempInDay(@RequestParam Map<String, String> requestParams) {
        String day = requestParams.get("day");
        String month = requestParams.get("month");
        String year = requestParams.get("year");

        return  ResponseEntity.ok(service.getMaxTempInDay(day, month, year));
    }

    @GetMapping("/min/date")
    public ResponseEntity<List<WeatherPerHours>> filterMinTempWeatherInDay(@RequestParam Map<String, String> requestParams) {
        String day = requestParams.get("day");
        String month = requestParams.get("month");
        String year = requestParams.get("year");

        return  ResponseEntity.ok(service.getMinTempInDay(day, month, year));
    }
}
