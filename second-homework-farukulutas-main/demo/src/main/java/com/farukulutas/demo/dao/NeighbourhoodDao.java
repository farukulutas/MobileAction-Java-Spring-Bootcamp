package com.farukulutas.demo.dao;

import com.farukulutas.demo.entity.District;
import com.farukulutas.demo.entity.Neighbourhood;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NeighbourhoodDao extends JpaRepository<Neighbourhood, Long> {

    @Query("SELECT n FROM Neighbourhood n WHERE n.district = ?1")
    List<Neighbourhood> findNeighbourhoodsByDistrict(District district);
}