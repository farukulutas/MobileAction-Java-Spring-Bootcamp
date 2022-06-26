package com.farukulutas.demo.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "VEHICLE")
public class Vehicle {

    @Id
    @SequenceGenerator(name = "Vehicle", sequenceName = "VEHICLE_NUMBER_ID_SEQ")
    @GeneratedValue(generator = "Vehicle")
    private Long id;

    @Column(name = "BRAND", length = 20, nullable = false)
    private int brand;

    @Column(name = "MODEL", length = 47, nullable = false)
    private int model;

    @Column(name = "PLATE", length = 8, nullable = false)
    private int plate;

    @ManyToOne
    private User user;
}