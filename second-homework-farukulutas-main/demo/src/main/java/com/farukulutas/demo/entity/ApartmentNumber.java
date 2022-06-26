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
@Table(name = "APARTMENT_NUMBER")
public class ApartmentNumber {

    @Id
    @SequenceGenerator(name = "ApartmentNumber", sequenceName = "APARTMENT_NUMBER_ID_SEQ")
    @GeneratedValue(generator = "ApartmentNumber")
    private Long id;

    @Column(name = "APARTMENT_NO")
    private int apartmentNo;
}