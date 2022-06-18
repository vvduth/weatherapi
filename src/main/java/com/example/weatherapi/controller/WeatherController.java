package com.example.weatherapi.controller;

import com.example.weatherapi.entity.WeatherPerHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import com.example.weatherapi.service.WeatherService;

import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:3000")
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

    @GetMapping("/list/avg/day")
    public List<WeatherPerHours> listAvgByDay() {
        return service.getListAvgBasedOnDay();
    }

    @GetMapping("/list/max/day")
    public List<WeatherPerHours> listMAXByDay() {
        return service.getListMAXBasedOnDay();
    }

    @GetMapping("/list/min/day")
    public List<WeatherPerHours> listMINByDay() {
        return service.getListMINBasedOnDay();
    }

    @GetMapping("/list/avg/month")
    public List<WeatherPerHours> listAvgByMonth() {
        return service.getListAvgBasedOnMonth();
    }

    @GetMapping("/list/max/month")
    public List<WeatherPerHours> listMAXByMonth() {
        return service.getListMAXBasedOnMonth();
    }

    @GetMapping("/list/min/month")
    public List<WeatherPerHours> listMINByMonth() {
        return service.getListMINBasedOnMonth();
    }

    @GetMapping("/list/avg/year")
    public List<WeatherPerHours> listAvgByYear() {
        return service.getListAvgBasedOnYear();
    }

    @GetMapping("/list/max/year")
    public List<WeatherPerHours> listMAXByYear() {
        return service.getListMAXBasedOnYear();
    }

    @GetMapping("/list/min/year")
    public List<WeatherPerHours> listMINByYear() {
        return service.getListMINBasedOnYear();
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
