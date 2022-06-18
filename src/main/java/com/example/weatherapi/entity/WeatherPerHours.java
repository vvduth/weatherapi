package com.example.weatherapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Data

@Entity
@Table(name="weather")
public class WeatherPerHours {

    @Id
    @GeneratedValue
    private int id;

    private double air_temp ;
    private int year , month, day ;
    private String time ;

    public WeatherPerHours(int id, double air_temp, int year) {
        this.id = id;
        this.air_temp = air_temp;
        this.year = year;
    }

    public WeatherPerHours(int id, double air_temp, int year, int month, int day, String time) {
        this.id = id;
        this.air_temp = air_temp;
        this.year = year;
        this.month = month;
        this.day = day;
        this.time = time;
    }
    public WeatherPerHours() {}

    public WeatherPerHours(int id, double air_temp, int year, int month, int day) {
        this.id = id;
        this.air_temp = air_temp;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public WeatherPerHours(int id, double air_temp, int year, int month) {
        this.id = id;
        this.air_temp = air_temp;
        this.year = year;
        this.month = month;
    }
}
