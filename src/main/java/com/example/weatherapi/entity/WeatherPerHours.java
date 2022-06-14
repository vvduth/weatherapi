package com.example.weatherapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="weather")
public class WeatherPerHours {

    @Id
    @GeneratedValue
    private int id;

    private double air_temp ;
    private int year , month, day ;
    private Time time ;



}
