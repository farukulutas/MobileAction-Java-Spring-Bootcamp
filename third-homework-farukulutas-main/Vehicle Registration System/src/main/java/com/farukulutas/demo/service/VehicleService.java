package com.farukulutas.demo.service;

import com.farukulutas.demo.dao.VehicleDao;
import com.farukulutas.demo.dto.VehicleDto;
import com.farukulutas.demo.entity.Vehicle;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleDao vehicleDao;

    public Object findVehiclesById(Long id) {
        return vehicleDao.getVehiclesByUserId( id);
    }

    public VehicleDto save(Vehicle vehicle) {
        VehicleDto vehicleDto = new VehicleDto();
        vehicle = vehicleDao.save(vehicle);

        vehicleDto.setBrand( vehicle.getBrand());
        vehicleDto.setModel( vehicle.getModel());
        vehicleDto.setUser( vehicle.getUser());
        vehicleDto.setId( vehicle.getId());
        vehicleDto.setPlate( vehicle.getPlate());

        return vehicleDto;
    }
    public VehicleDto update(Vehicle vehicle) {
        Vehicle vehicle1 = vehicleDao.getVehicleById( vehicle.getId());

        vehicle1.setBrand( vehicle.getBrand());
        vehicle1.setModel( vehicle.getModel());
        vehicle1.setPlate( vehicle.getPlate());
        vehicle1.setUser( vehicle.getUser());

        vehicleDao.save( vehicle1);

        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId( vehicle.getId());
        vehicleDto.setBrand( vehicle.getBrand());
        vehicleDto.setModel( vehicle.getModel());
        vehicleDto.setPlate( vehicle.getPlate());
        vehicleDto.setUser( vehicle.getUser());

        return vehicleDto;
    }

    public List<Vehicle> findVehiclesByBrandAndModel(String brand, String model) {
        return vehicleDao.findByBrandAndModel( brand, model);
    }

    // I skip the implementation of ResponseEntity and dto, you can check the other methods
    public String deleteVehicle(Long id) {
        vehicleDao.deleteByUserId( id);

        return "Vehicle deleted.";
    }
}