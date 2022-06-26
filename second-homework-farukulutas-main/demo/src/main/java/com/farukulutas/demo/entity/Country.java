package com.farukulutas.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "COUNTRY")
public class Country {

    @Id
    @SequenceGenerator(name = "Country", sequenceName = "COUNTRY_ID_SEQ")
    @GeneratedValue(generator = "Country")
    private Long id;

    @Column(name = "COUNTRY_NAME", length = 56, nullable = false)
    private String countryName;

    @Column(name = "COUNTRY_CODE", length = 6, nullable = false)
    private int countryCode;

    public Country orElseThrow() {
        return null;
    }
}