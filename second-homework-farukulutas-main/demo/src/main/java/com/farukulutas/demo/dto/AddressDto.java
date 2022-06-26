package com.farukulutas.demo.dto;

import com.farukulutas.demo.entity.ApartmentNumber;
import com.farukulutas.demo.entity.DoorNumber;
import com.farukulutas.demo.entity.City;
import com.farukulutas.demo.entity.District;
import com.farukulutas.demo.entity.Street;
import com.farukulutas.demo.entity.Neighbourhood;
import com.farukulutas.demo.entity.Country;

import lombok.Data;

@Data
public class AddressDto {

    private Long id;
    private String addressName;
    private Country country;
    private City city;
    private District district;
    private Neighbourhood neighbourhood;
    private Street street;
    private DoorNumber doorNo;
    private ApartmentNumber apartmentNo;
}