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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAir_temp() {
        return air_temp;
    }

    public void setAir_temp(double air_temp) {
        this.air_temp = air_temp;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
