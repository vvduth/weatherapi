package com.example.weatherapi.repository;

import com.example.weatherapi.entity.WeatherPerHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<WeatherPerHours, Integer> {

}
