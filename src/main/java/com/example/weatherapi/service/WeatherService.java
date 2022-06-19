package com.example.weatherapi.service;

import com.example.weatherapi.entity.WeatherPerHours;
import com.example.weatherapi.repository.Interger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.weatherapi.repository.WeatherRepository;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Service
public class WeatherService {
    @Autowired
    private WeatherRepository weatherRepository ;

    public WeatherPerHours saveWeather(WeatherPerHours weather) {
        return weatherRepository.save(weather);
    }

    public List<WeatherPerHours> getWeathers() {
        return (List<WeatherPerHours>) weatherRepository.findAll();
    }


    public List<WeatherPerHours> pagination(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging =  PageRequest.of(pageNo, pageSize, Sort.by(sortBy));


        Page<WeatherPerHours> pagedResult = weatherRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return null ;
        }
    }

    public List<WeatherPerHours> filterWeather(String query) {
        List<WeatherPerHours> filteredWeather = weatherRepository.loadedWeather(query);
        return  filteredWeather ;
    }

    public List<WeatherPerHours> getMaxTempInDay(String day, String month, String year) {
        List<WeatherPerHours> filteredWeather = weatherRepository.maxTempInDay(day, month, year);
        return  filteredWeather ;
    }
    public List<WeatherPerHours> getMaxTempInMonth( String month, String year ) {
        List<WeatherPerHours> filteredWeater = weatherRepository.maxTempInMonth( month, year);
        return filteredWeater ;
    }

    public List<WeatherPerHours> getMaxTempInYear( String year ) {
        List<WeatherPerHours> filteredWeater = weatherRepository.maxTempInYear(year);
        return filteredWeater ;
    }

    public List<WeatherPerHours> getMinTempInDay(String day, String month, String year ) {
        List<WeatherPerHours> filteredWeater = weatherRepository.minTempInDay(day, month, year);
        return filteredWeater ;
    }

    public List<WeatherPerHours> getMinTempInMonth( String month, String year ) {
        List<WeatherPerHours> filteredWeater = weatherRepository.minTempInMonth( month, year);
        return filteredWeater ;
    }

    public List<WeatherPerHours> getMinTempInYear( String year ) {
        List<WeatherPerHours> filteredWeater = weatherRepository.minTempInYear(year);
        return filteredWeater ;
    }

    public List<WeatherPerHours> getListAvgBasedOnDay(  ) {
        List<WeatherPerHours> filteredWeater = weatherRepository.avgBasedOnDay();
        return filteredWeater ;
    }

    public List<WeatherPerHours> getListAvgBasedOnDayPagination( Integer page ) {
        int startInt = page * 10 ;
        int endInt = 10 ;
        String start = String.valueOf(startInt);
        String end  = String.valueOf(endInt);
        List<WeatherPerHours> filteredWeater = weatherRepository.avgBasedOnDayPagination(startInt, endInt);
        return filteredWeater ;
    }

    public List<WeatherPerHours> getListMaxBasedOnDayPagination( Integer page ) {
        int startInt = page * 10 ;
        int endInt = 10 ;
        String start = String.valueOf(startInt);
        String end  = String.valueOf(endInt);
        List<WeatherPerHours> filteredWeater = weatherRepository.maxBasedOnDayPagination(startInt, endInt);
        return filteredWeater ;
    }

    public List<WeatherPerHours> getListMinBasedOnDayPagination( Integer page ) {
        int startInt = page * 10 ;
        int endInt = 10 ;
        String start = String.valueOf(startInt);
        String end  = String.valueOf(endInt);
        List<WeatherPerHours> filteredWeater = weatherRepository.minBasedOnDayPagination(startInt, endInt);
        return filteredWeater ;
    }
    public List<WeatherPerHours> getListMAXBasedOnDay(  ) {
        List<WeatherPerHours> filteredWeater = weatherRepository.MAXBasedOnDay();
        return filteredWeater ;
    }
    public List<WeatherPerHours> getListMINBasedOnDay(  ) {
        List<WeatherPerHours> filteredWeater = weatherRepository.MINBasedOnDay();
        return filteredWeater ;
    }

    public List<WeatherPerHours> getListAvgBasedOnMonth(  ) {
        List<WeatherPerHours> filteredWeater = weatherRepository.avgBasedOnMonth();
        return filteredWeater ;
    }
    public List<WeatherPerHours> getListMAXBasedOnMonth(  ) {
        List<WeatherPerHours> filteredWeater = weatherRepository.MAXBasedOnMonth();
        return filteredWeater ;
    }
    public List<WeatherPerHours> getListMINBasedOnMonth(  ) {
        List<WeatherPerHours> filteredWeater = weatherRepository.MINBasedOnMonth();
        return filteredWeater ;
    }

    public List<WeatherPerHours> getListAvgBasedOnYear(  ) {
        List<WeatherPerHours> filteredWeater = weatherRepository.avgBasedOnYear();
        return filteredWeater ;
    }
    public List<WeatherPerHours> getListMAXBasedOnYear(  ) {
        List<WeatherPerHours> filteredWeater = weatherRepository.MAXBasedOnYear();
        return filteredWeater ;
    }
    public List<WeatherPerHours> getListMINBasedOnYear(  ) {
        List<WeatherPerHours> filteredWeater = weatherRepository.MINBasedOnYear();
        return filteredWeater ;
    }

    public double getAvgTempInDay(String day, String month, String year) {
        double avgTemp = weatherRepository.avgTempInDay(day, month, year);
        return  avgTemp ;
    }

    public double getAvgTempInMonth(String month, String year) {
        double avgTemp = weatherRepository.avgTempInMonth(month, year);
        return  avgTemp ;
    }

    public double getAvgTempInYear(String year) {
        double avgTemp = weatherRepository.avgTempInYear(year);
        return  avgTemp ;
    }
}
