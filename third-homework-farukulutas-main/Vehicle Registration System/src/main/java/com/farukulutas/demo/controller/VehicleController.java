package com.farukulutas.demo.controller;

import com.farukulutas.demo.dto.VehicleDto;
import com.farukulutas.demo.entity.Vehicle;
import com.farukulutas.demo.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping("/save-vehicle")
    public ResponseEntity<VehicleDto> save(@Valid @RequestBody Vehicle vehicle){
        // if vehicle valid, throw, plate is lowerCase noSpace noTurkishLetter
        VehicleDto vehicleDto = vehicleService.save( vehicle);

        return new ResponseEntity<>(vehicleDto, HttpStatus.CREATED);
    }

    // update vehicle
    @PutMapping
    public ResponseEntity<VehicleDto> update(@RequestBody Vehicle vehicle){
        VehicleDto vehicleDto = vehicleService.update( vehicle);

        return new ResponseEntity<>(vehicleDto, HttpStatus.CREATED);
    }

    // get vehicles by brand and model
    @GetMapping
    public ResponseEntity findByBrandAndModel( @RequestBody String brand, String model){
        return ResponseEntity.ok().body(vehicleService.findVehiclesByBrandAndModel( brand, model));
    }

    // delete vehicle
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        String response = vehicleService.deleteVehicle(id);

        if(response == null) {
            return  new ResponseEntity<String>("Vehicle not found !",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}