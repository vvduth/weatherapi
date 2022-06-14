package com.example.weatherapi.service;

import com.example.weatherapi.entity.WeatherImport;
import com.example.weatherapi.helper.CSVHelper;
import com.example.weatherapi.repository.WeatherImportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CSVService {
    @Autowired
    WeatherImportRepository repository;
    public void save(MultipartFile file) {
        try {
            List<WeatherImport> weatherImports = CSVHelper.csvToTutorials(file.getInputStream());
            repository.saveAll(weatherImports);
        } catch (IOException e) {
            System.out.println("Failed in CSV service");
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
    public List<WeatherImport> getAllTutorials() {
        return repository.findAll();
    }
}
