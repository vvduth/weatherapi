package com.example.weatherapi.repository;

import com.example.weatherapi.entity.WeatherImport;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WeatherImportRepository extends JpaRepository<WeatherImport, Long> {

}
