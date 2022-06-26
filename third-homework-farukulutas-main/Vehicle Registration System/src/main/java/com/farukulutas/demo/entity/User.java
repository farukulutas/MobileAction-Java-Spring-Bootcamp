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
@Table(name = "USER_ACC")
public class User {

    @Id
    @SequenceGenerator(name = "UserAcc", sequenceName = "USER_ACC_ID_SEQ")
    @GeneratedValue(generator = "UserAcc")
    private Long id;

    @Column(name = "NAME", unique = true, length = 16, nullable = false)
    private String name;

    @Column(name = "SURNAME", unique = true, length = 16, nullable = false)
    private String surname;

    @Column(name = "USERNAME", unique = true, length = 45, nullable = false)
    private String username;

    @Column(name = "PASSWORD", length = 64, nullable = false)
    private String password;
}