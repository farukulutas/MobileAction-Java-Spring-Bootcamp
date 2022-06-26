package com.farukulutas.demo.dao;

import com.farukulutas.demo.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleDao extends JpaRepository<Vehicle, Long> {
    @Query("DELETE FROM Vehicle WHERE user.id = ?1")
    void deleteByUserId(Long id);

    @Query("SELECT v FROM Vehicle v WHERE v.id = ?1")
    Vehicle getVehicleById(Long id);

    @Query("SELECT v FROM Vehicle v WHERE v.user.id = ?1")
    List<Vehicle> getVehiclesByUserId(Long id);

    @Query("SELECT v FROM Vehicle v WHERE v.brand = ?1 AND v.model = ?2")
    List<Vehicle> findByBrandAndModel(String brand, String model);
}