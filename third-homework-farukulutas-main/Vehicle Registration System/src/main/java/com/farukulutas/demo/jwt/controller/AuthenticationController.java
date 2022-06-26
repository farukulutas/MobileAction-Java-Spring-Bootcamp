package com.farukulutas.demo.jwt.controller;

import com.farukulutas.demo.dao.UserDao;
import com.farukulutas.demo.gen.response.RestResponse;
import com.farukulutas.demo.jwt.dto.JwtLoginRequestDto;
import com.farukulutas.demo.jwt.service.AuthenticationService;
import com.farukulutas.demo.dto.UserDto;
import com.farukulutas.demo.entity.User;
import com.farukulutas.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity save(@Valid @RequestBody User cusCustomerSaveRequestDto){
        UserDao userDto = authenticationService.register( cusCustomerSaveRequestDto);

        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody JwtLoginRequestDto jwtLoginRequestDto){

        String login = authenticationService.login(jwtLoginRequestDto);

        return ResponseEntity.ok(RestResponse.of(login));
    }
}
