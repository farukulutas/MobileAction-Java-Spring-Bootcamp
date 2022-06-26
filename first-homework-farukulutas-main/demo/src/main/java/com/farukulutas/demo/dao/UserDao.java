package com.farukulutas.demo.dao;

import com.farukulutas.demo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}