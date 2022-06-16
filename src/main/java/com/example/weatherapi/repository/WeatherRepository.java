package com.example.weatherapi.repository;

import com.example.weatherapi.entity.WeatherPerHours;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface WeatherRepository extends PagingAndSortingRepository<WeatherPerHours, Integer> {

    @Query(value = "SELECT * FROM weather WHERE air_temp < 0 AND year = :query ;", nativeQuery = true)
    List<WeatherPerHours> loadedWeather(String query);

    // Query to return max temp in the day
    @Query(value = "SELECT  * FROM weather WHERE air_temp = (SELECT MAX(air_temp) FROM weather WHERE day=:day AND month=:month AND year=:year ) AND day=:day AND month=:month AND year=:year ;", nativeQuery = true)
    List<WeatherPerHours> maxTempInDay(String day, String month, String year);

    // max temp in the month
    @Query(value = "SELECT  * FROM weather WHERE air_temp = (SELECT MAX(air_temp) FROM weather WHERE month=:month AND year=:year ) AND month=:month AND year=:year ;", nativeQuery = true)
    List<WeatherPerHours> maxTempInMonth(String month, String year);

    // max temp in the year
    @Query(value = "SELECT  * FROM weather WHERE air_temp = (SELECT MAX(air_temp) FROM weather WHERE year=:year ) AND year=:year ;", nativeQuery = true)
    List<WeatherPerHours> maxTempInYear(String year);

    // Min temp in the day
    @Query(value = "SELECT  * FROM weather WHERE air_temp = (SELECT MIN(air_temp) FROM weather WHERE day=:day AND month=:month AND year=:year ) AND day=:day AND month=:month AND year=:year ;", nativeQuery = true)
    List<WeatherPerHours> minTempInDay(String day, String month, String year);

    // Min temp in month
    @Query(value = "SELECT  * FROM weather WHERE air_temp = (SELECT MIN(air_temp) FROM weather WHERE month=:month AND year=:year ) AND month=:month AND year=:year ;", nativeQuery = true)
    List<WeatherPerHours> minTempInMonth(String month, String year);

    // Min temp in the year
    @Query(value = "SELECT  * FROM weather WHERE air_temp = (SELECT MIN(air_temp) FROM weather WHERE year=:year ) AND year=:year ;", nativeQuery = true)
    List<WeatherPerHours> minTempInYear(String year);

    // avg temp in the day
    @Query(value = "SELECT AVG(air_temp) FROM weather WHERE day=:day AND month=:month AND year=:year ;", nativeQuery = true)
    double avgTempInDay (String day, String month, String year);

    // avg temp in the month
    @Query(value = "SELECT AVG(air_temp) FROM weather WHERE month=:month AND year=:year ;", nativeQuery = true)
    double avgTempInMonth (String month, String year);

    // avg temp in the year
    @Query(value = "SELECT AVG(air_temp) FROM weather WHERE year=:year ;", nativeQuery = true)
    double avgTempInYear (String year);


}
