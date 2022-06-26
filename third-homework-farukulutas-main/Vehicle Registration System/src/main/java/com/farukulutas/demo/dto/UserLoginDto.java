package com.farukulutas.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserLoginDto {

    @NotNull
    @NotEmpty
    private Long username;
    private String password;
}