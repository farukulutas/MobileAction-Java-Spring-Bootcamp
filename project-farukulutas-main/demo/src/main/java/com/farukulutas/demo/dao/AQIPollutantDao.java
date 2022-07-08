package com.farukulutas.demo.dao;

import com.farukulutas.demo.entity.AQIPollutant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AQIPollutantDao extends JpaRepository<AQIPollutant, Long> {
}