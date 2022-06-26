package com.farukulutas.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USER_COMMENT")
public class UserComment {

    @Id
    private Long id;

    @Column(name = "COMMENT", length = 500, nullable = false)
    private String comment;

    @Column(name = "COMMENT_DATE", length = 25, nullable = false)
    private Date commentDate;

    @Column(name = "PRODUCT_ID", length = 14, nullable = false)
    private Long productId;

    @ManyToOne
    private User user;
}