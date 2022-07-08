package com.farukulutas.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "aqi_pollutants")
public class AQIPollutant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "co", length = 50, nullable = false)
    private String co;

    @Column(name = "o3", length = 50, nullable = false)
    private String o3;

    @Column(name = "so2", length = 50, nullable = false)
    private String so2;

    @Column(name = "date", length = 50, nullable = false)
    private LocalDate date;
}