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
@Table(name = "DOOR_NUMBER")
public class DoorNumber {

    @Id
    @SequenceGenerator(name = "DoorNumber", sequenceName = "DOOR_NUMBER_ID_SEQ")
    @GeneratedValue(generator = "DoorNumber")
    private Long id;

    @Column(name = "DOOR_NO", nullable = false)
    private int doorNo;
}