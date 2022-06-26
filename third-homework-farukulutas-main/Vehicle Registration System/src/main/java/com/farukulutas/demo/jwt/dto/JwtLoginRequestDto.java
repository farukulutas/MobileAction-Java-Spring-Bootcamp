package com.farukulutas.demo.jwt.dto;

import lombok.Data;

@Data
public class JwtLoginRequestDto {

    private Long identityNo;
    private String password;
}
