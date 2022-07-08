package com.farukulutas.demo.entity;

import javax.persistence.*;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "city_name", length = 50, nullable = false)
    private String cityName;

    @Column(name = "start_date", length = 50, nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", length = 50, nullable = false)
    private LocalDate endDate;

    @Column(name = "lat", length = 50)
    private String lat;

    @Column(name = "lon", length = 50)
    private String lon;

    @OneToMany
    @Column(name = "pollutants")
    private Collection<AQIPollutant> pollutants = new ArrayList<>();
}