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

    @GetMapping("/all2")
    public ResponseEntity<List<WeatherPerHours>> pagination(@RequestParam(defaultValue = "0") Integer pageNo,
                                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                                            @RequestParam(defaultValue = "id") String sortBy) {
        return  ResponseEntity.ok(service.pagination(pageNo, pageSize,sortBy));
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

        if (day != null && month !=null && year != null ) {
            return  ResponseEntity.ok(service.getMaxTempInDay(day, month, year));
        } else if  (day == null && month !=null && year != null) {
            return  ResponseEntity.ok(service.getMaxTempInMonth(month, year));
        } else if  (day == null && month ==null && year != null) {
            return  ResponseEntity.ok(service.getMaxTempInYear(year));
        } else {
            return null;
        }
    }

    @GetMapping("/min/date")
    public ResponseEntity<List<WeatherPerHours>> filterMinTempWeatherInDay(@RequestParam Map<String, String> requestParams) {
        String day = requestParams.get("day");
        String month = requestParams.get("month");
        String year = requestParams.get("year");
        if (day != null && month !=null && year != null ) {
            return  ResponseEntity.ok(service.getMinTempInDay(day, month, year));
        } else if  (day == null && month !=null && year != null) {
            return  ResponseEntity.ok(service.getMinTempInMonth(month, year));
        } else if  (day == null && month ==null && year != null) {
            return  ResponseEntity.ok(service.getMinTempInYear(year));
        } else {
            return null;
        }

    }

    @GetMapping("/avg/date")
    public ResponseEntity<Double> avgTempInday(@RequestParam Map<String, String> requestParams) {
        String day = requestParams.get("day");
        String month = requestParams.get("month");
        String year = requestParams.get("year");

        if (day != null && month !=null && year != null ) {
            return  ResponseEntity.ok(service.getAvgTempInDay(day, month, year));
        } else if  (day == null && month !=null && year != null) {
            return  ResponseEntity.ok(service.getAvgTempInMonth(month, year));
        } else if  (day == null && month ==null && year != null) {
            return  ResponseEntity.ok(service.getAvgTempInYear(year));
        } else {
            return null;
        }
    }
}
