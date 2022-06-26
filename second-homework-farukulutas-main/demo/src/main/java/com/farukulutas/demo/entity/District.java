package com.farukulutas.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "DISTRICT")
public class District {

    @Id
    @SequenceGenerator(name = "District", sequenceName = "DISTRICT_ID_SEQ")
    @GeneratedValue(generator = "District")
    private Long id;

    @Column(name = "DISTRICT_NAME", length = 85, nullable = false)
    private String districtName;

    @OneToMany
    @Column(name = "NEIGHBOURHOOD", nullable = false)
    private List<Neighbourhood> neighbourhood;

    @ManyToOne
    private City city;

}