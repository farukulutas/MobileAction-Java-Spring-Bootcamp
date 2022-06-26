package com.farukulutas.demo.service;

import com.farukulutas.demo.dao.UserDao;
import com.farukulutas.demo.dao.VehicleDao;
import com.farukulutas.demo.dto.UserDto;
import com.farukulutas.demo.dto.UserLoginDto;
import com.farukulutas.demo.entity.User;
import com.farukulutas.demo.jwt.security.JwtTokenGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    private final VehicleDao vehicleDao;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtTokenGenerator;

    public ResponseEntity<String> updatePassword(Long id, String oldPassword, String newPassword, String matchingPassword) {
        User user = userDao.findUserById(id);

        if ( !user.getPassword().contentEquals( oldPassword) ) {
            return new ResponseEntity<>( "not matched", HttpStatus.BAD_REQUEST);
        }

        if ( newPassword.contentEquals( matchingPassword) ) {
            user.setPassword( newPassword);
            userDao.save(user);
            return new ResponseEntity<>( "success", HttpStatus.OK);
        }

        return new ResponseEntity<>( "fail", HttpStatus.BAD_REQUEST);
    }

    // I skip the implementation of ResponseEntity and dto, you can check the prev methods
    public String deleteUser(Long id) {
        vehicleDao.deleteByUserId( id);
        userDao.deleteById( id);

        return "User and vehicles deleted.";
    }

    public User findByIdWithControl(Long id) throws Exception {

        Optional<User> optionalEntity = userDao.findById(id);

        User entity;
        if (optionalEntity.isPresent()){
            entity = optionalEntity.get();
        } else {
            throw new Exception("not found");
        }

        return entity;
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}