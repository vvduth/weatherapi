package com.example.weatherapi.repository;

import com.example.weatherapi.entity.WeatherPerHours;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeatherRepository extends JpaRepository<WeatherPerHours, Integer> {

    @Query(value = "SELECT * FROM weather WHERE air_temp < 0 AND year = :query ;", nativeQuery = true)
    List<WeatherPerHours> loadedWeather(String query);

    // Query to return max temp in the day
    @Query(value = "SELECT  * FROM weather WHERE air_temp = (SELECT MAX(air_temp) FROM weather WHERE day=:day AND month=:month AND year=:year ) AND day=:day AND month=:month AND year=:year ;", nativeQuery = true)
    List<WeatherPerHours> maxTempInDay(String day, String month, String year);

    @Query(value = "SELECT  * FROM weather WHERE air_temp = (SELECT MIN(air_temp) FROM weather WHERE day=:day AND month=:month AND year=:year ) AND day=:day AND month=:month AND year=:year ;", nativeQuery = true)
    List<WeatherPerHours> minTempInDay(String day, String month, String year);
}
