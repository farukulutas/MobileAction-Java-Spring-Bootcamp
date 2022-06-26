package com.farukulutas.demo.dto;

import com.farukulutas.demo.entity.User;
import lombok.Data;

@Data
public class VehicleDto {

    private Long id;
    private int brand;
    private int model;
    private int plate;
    private User user;
}