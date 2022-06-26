package com.farukulutas.demo.dao;

import com.farukulutas.demo.entity.City;
import com.farukulutas.demo.entity.District;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DistrictDao extends JpaRepository<District, Long> {

    @Query("SELECT d FROM District d WHERE d.city = ?1")
    List<District> findDistrictsByCity(City city);
}