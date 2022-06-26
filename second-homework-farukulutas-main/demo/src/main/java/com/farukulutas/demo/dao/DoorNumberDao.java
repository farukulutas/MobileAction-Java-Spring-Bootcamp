package com.farukulutas.demo.dao;

import com.farukulutas.demo.entity.DoorNumber;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoorNumberDao extends JpaRepository<DoorNumber, Long> {
}