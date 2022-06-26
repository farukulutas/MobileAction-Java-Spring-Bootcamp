package com.farukulutas.demo.controller;

import java.util.List;

import com.farukulutas.demo.dao.UserDao;
import com.farukulutas.demo.entity.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {

        user = userDao.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> userList = userDao.findAll();

        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

        User myUser = userDao.findById(id).orElseThrow();

        return ResponseEntity.ok(myUser);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUserById(@RequestBody User user) {

        if (user.getId() == null) {
            throw new RuntimeException("User id cannot be empty!");
        }

        boolean isExist = userDao.existsById(user.getId());
        if (!isExist) {
            throw new RuntimeException("User does not exist!");
        }

        user = userDao.save(user);

        return ResponseEntity.ok(user);
    }

    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<User> setPassive(@PathVariable Long id) {

        User user = userDao.findById(id).orElseThrow();

        user.setIsStateActive(Boolean.FALSE);

        user = userDao.save(user);

        return ResponseEntity.ok(user);
    }
}
