package com.farukulutas.demo.controller;

import com.farukulutas.demo.dao.UserDao;
import com.farukulutas.demo.dto.UserLoginDto;
import com.farukulutas.demo.entity.User;
import com.farukulutas.demo.service.UserService;
import com.farukulutas.demo.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserDao userDao;
    private final VehicleService vehicleService;

    /*
    // register
    @PostMapping("/save-user")
    public ResponseEntity<UserDao> save(@Valid @RequestBody User user){
        UserDao userDao = userDao.save( user);

        return new ResponseEntity<>(userDao, HttpStatus.CREATED);
    }

    // login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDto userLoginDto){

        String login = userService.login(userLoginDto);

        return new ResponseEntity<>(login, HttpStatus.CREATED);
    }
    */

    // change password (mutlaka login, old pass, new pass)
    @PatchMapping("/{id}/change-password")
    public ResponseEntity<String> changePassword(@PathVariable Long id, @RequestBody String oldPassword, String newPassword, String confirmNewPassword) {
        ResponseEntity<String> createdResponse = userService.updatePassword(id, oldPassword, newPassword, confirmNewPassword);

        if ( Objects.requireNonNull(createdResponse.getBody()).contentEquals( "success") ) {
            return new ResponseEntity<>("Password changed successfully.", HttpStatus.CREATED);
        }

        return new ResponseEntity<>(createdResponse.getBody(), HttpStatus.BAD_REQUEST);
    }

    // get all vehicles of user
    @GetMapping("/{id}")
    public ResponseEntity getVehicles(@PathVariable Long id){
        return ResponseEntity.ok().body(vehicleService.findVehiclesById( id));
    }

    // delete user (and all vehicles of him/her)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        String response = userService.deleteUser(id);

        if(response == null) {
            return  new ResponseEntity<>("User not found !",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}