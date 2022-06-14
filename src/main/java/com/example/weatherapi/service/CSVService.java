package com.example.weatherapi.service;

import com.example.weatherapi.entity.WeatherImport;
import com.example.weatherapi.helper.CSVHelper;
import com.example.weatherapi.repository.WeatherImportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CSVService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSVService.class);
    @Autowired
    WeatherImportRepository repository;
    public void save(MultipartFile file) {
        try {
            List<WeatherImport> weatherImports = CSVHelper.csvToTutorials(file.getInputStream());
            repository.saveAll(weatherImports);
            LOGGER.trace("We are in try save method in CSV service");
        } catch (IOException e) {
            LOGGER.trace("save method service throws an error");
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
    public ByteArrayInputStream load() {
        List<WeatherImport> tutorials = repository.findAll();

        ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
        return in;
    }
    public List<WeatherImport> getAllTutorials() {
        return repository.findAll();
    }
}
