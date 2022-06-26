package com.farukulutas.demo.dao;

import com.farukulutas.demo.entity.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryDao extends JpaRepository<Country, Long> {

    @Query("SELECT c FROM Country c WHERE c.countryCode = ?1")
    public Country findByCountryCode(int countryCode);
}