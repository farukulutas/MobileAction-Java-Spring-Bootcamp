package com.farukulutas.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @NotNull
    @NotEmpty
    private Long id;
    private String username;
    private String password;
}