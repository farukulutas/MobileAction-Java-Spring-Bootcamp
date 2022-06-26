package com.farukulutas.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CITY")
public class City {

    @Id
    @SequenceGenerator(name = "City", sequenceName = "CITY_ID_SEQ")
    @GeneratedValue(generator = "City")
    private Long id;

    @Column(name = "CITY_NAME", length = 85, nullable = false)
    private String cityName;

    @Column(name = "PLATE", nullable = false)
    private int plate;

    @OneToMany
    @Column(name = "DISTRICT", nullable = false)
    private List<District> district;

    public City orElseThrow() {
        return null;
    }
}