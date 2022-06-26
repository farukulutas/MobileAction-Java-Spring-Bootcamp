package com.farukulutas.demo.jwt.service;

import com.farukulutas.demo.dao.UserDao;
import com.farukulutas.demo.jwt.dto.JwtLoginRequestDto;
import com.farukulutas.demo.jwt.enums.JwtConstant;
import com.farukulutas.demo.jwt.security.JwtTokenGenerator;
import com.farukulutas.demo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtTokenGenerator jwtTokenGenerator;

    public UserDao register(User user) {
        return (UserDao) userDao.save(user);
    }

    public String login(JwtLoginRequestDto jwtLoginRequestDto) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                jwtLoginRequestDto.getIdentityNo().toString(), jwtLoginRequestDto.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenGenerator.generateJwtToken(authentication);

        String fullToken = JwtConstant.BEARER.getConstant() + token;

        return fullToken;
    }
}
