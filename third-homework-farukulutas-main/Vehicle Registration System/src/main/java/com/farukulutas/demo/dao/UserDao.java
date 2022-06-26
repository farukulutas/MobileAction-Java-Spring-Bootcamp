package com.farukulutas.demo.dao;

import com.farukulutas.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.id = ?1")
    User findUserById(Long id);

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUsername(String username);
}