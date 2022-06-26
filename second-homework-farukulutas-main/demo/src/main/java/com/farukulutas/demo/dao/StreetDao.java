package com.farukulutas.demo.dao;

import com.farukulutas.demo.entity.Neighbourhood;
import com.farukulutas.demo.entity.Street;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StreetDao extends JpaRepository<Street, Long> {
    @Query("SELECT s FROM Street s WHERE s.neighbourhood = ?1")
    List<Street> findStreetsByNeighbourhood(Neighbourhood neighbourhood);
}