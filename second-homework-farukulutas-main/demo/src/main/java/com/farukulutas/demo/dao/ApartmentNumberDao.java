package com.farukulutas.demo.dao;

import com.farukulutas.demo.entity.ApartmentNumber;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentNumberDao extends JpaRepository<ApartmentNumber, Long> {
}