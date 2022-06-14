package com.example.weatherapi.entity;

import javax.persistence.*;
import java.sql.Time;
@Entity
@Table(name="weather")
public class WeatherImport {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="day")
    private int day ;

    @Column(name="year")
    private int year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public double getAir_temp() {
        return air_temp;
    }

    public void setAir_temp(double air_temp) {
        this.air_temp = air_temp;
    }

    public WeatherImport(int day, int year, int month, Time time, double air_temp) {
        this.day = day;
        this.year = year;
        this.month = month;
        this.time = time;
        this.air_temp = air_temp;
    }

    @Column(name="month")
    private int month;

    public WeatherImport(int id, int day, int year, int month, Time time, double air_temp) {
        this.id = id;
        this.day = day;
        this.year = year;
        this.month = month;
        this.time = time;
        this.air_temp = air_temp;
    }

    @Column(name="time")
    private Time time;


    @Column(name="air_temp")
    private double air_temp;






}
