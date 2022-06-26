package com.farukulutas.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USERS")
public class User {

    @Id
    private Long id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @Column(name = "EMAIL", length = 50, nullable = false)
    private String email;

    @Column(name = "PHONE_NO", length = 15, nullable = false)
    private String phoneNo;

    @Column(name = "DATE", length = 10, nullable = false)
    private Date dateOfBirth;

    private Boolean isStateActive;
}