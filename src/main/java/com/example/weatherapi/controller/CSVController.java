package com.example.weatherapi.controller;

import com.example.weatherapi.entity.WeatherImport;
import com.example.weatherapi.helper.CSVHelper;
import com.example.weatherapi.messeage.ResponseMessage;
import com.example.weatherapi.service.CSVService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin("http://localhost:8080")
@Controller
@RequestMapping("/api/csv")
public class CSVController {
    @Autowired
    CSVService fileService ;
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                fileService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();

                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";

                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(e.toString()));
            }
        }
        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
}
