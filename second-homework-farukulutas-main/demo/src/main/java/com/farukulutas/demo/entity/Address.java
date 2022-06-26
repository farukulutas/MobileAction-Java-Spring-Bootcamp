package com.farukulutas.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "ADDRESS")
public class Address {

    @Id
    @SequenceGenerator(name = "Address", sequenceName = "ADDRESS_ID_SEQ")
    @GeneratedValue(generator = "Address")
    private Long id;

    @Column(name = "ADDRESS_NAME", length = 50, nullable = false)
    private String addressName;

    @OneToOne
    private Country country;

    @OneToOne
    private City city;

    @OneToOne
    private District district;

    @OneToOne
    private Neighbourhood neighbourhood;

    @OneToOne
    private Street street;

    @OneToOne
    private DoorNumber doorNo;

    @OneToOne
    private ApartmentNumber apartmentNo;
}