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
@Table(name = "NEIGHBOURHOOD")
public class Neighbourhood {

    @Id
    @SequenceGenerator(name = "Neighbourhood", sequenceName = "NEIGHBOURHOOD_ID_SEQ")
    @GeneratedValue(generator = "Neighbourhood")
    private Long id;

    @Column(name = "NEIGHBOURHOOD_NAME", length = 85, nullable = false)
    private String neighbourhoodName;

    @OneToMany
    @Column(name = "STREET", nullable = false)
    private List<Street> street;

    @ManyToOne
    private District district;
}