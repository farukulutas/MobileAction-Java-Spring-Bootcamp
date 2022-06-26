package com.farukulutas.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farukulutas.demo.dao.AddressDao;
import com.farukulutas.demo.dao.CityDao;
import com.farukulutas.demo.dao.CountryDao;
import com.farukulutas.demo.dao.DistrictDao;
import com.farukulutas.demo.dao.NeighbourhoodDao;
import com.farukulutas.demo.dao.StreetDao;
import com.farukulutas.demo.entity.Address;
import com.farukulutas.demo.entity.City;
import com.farukulutas.demo.entity.Country;
import com.farukulutas.demo.entity.District;
import com.farukulutas.demo.entity.Neighbourhood;
import com.farukulutas.demo.entity.Street;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressDao addressDao;
    private final CityDao cityDao;
    private final CountryDao countryDao;
    private final DistrictDao districtDao;
    private final NeighbourhoodDao neighbourhoodDao;
    private final StreetDao streetDao;

    @PostMapping("/save-country")
    public ResponseEntity<Country> saveCountry(@RequestBody Country country) {

        country = countryDao.save(country);

        return new ResponseEntity<>(country, HttpStatus.CREATED);
    }

    @GetMapping("/find-country/{countryCode}")
    public ResponseEntity<Country> findCountryByCountryCode(@PathVariable int countryCode) {

        Country country = countryDao.findByCountryCode(countryCode).orElseThrow();

        return ResponseEntity.ok(country);
    }

    @PostMapping("/save-city")
    public ResponseEntity<City> saveCity(@RequestBody City city) {

        city = cityDao.save(city);

        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

    @GetMapping("/find-city/{plate}")
    public ResponseEntity<City> findCityByPlate(@PathVariable int plate) {

        City city = cityDao.findCityByPlate(plate).orElseThrow();

        return ResponseEntity.ok(city);
    }

    @PostMapping("/save-district")
    public ResponseEntity<District> saveDistrict(@RequestBody District district) {

        district = districtDao.save(district);

        return new ResponseEntity<>(district, HttpStatus.CREATED);
    }

    @GetMapping("/find-districts/{city}")
    public ResponseEntity<List<District>> findDistrictsOfCity(@PathVariable City city) {

        List<District> dList = districtDao.findDistrictsByCity(city);

        return ResponseEntity.ok(dList);
    }

    @PostMapping("/save-neighbourhood")
    public ResponseEntity<Neighbourhood> saveNeighbourhood(@RequestBody Neighbourhood neighbourhood) {

        neighbourhood = neighbourhoodDao.save(neighbourhood);

        return new ResponseEntity<>(neighbourhood, HttpStatus.CREATED);
    }

    @PatchMapping("/update-neighbourhood/{id}")
    public ResponseEntity<Neighbourhood> updateNeighbourhoodName(@PathVariable Long id, @RequestBody String newName) {

        Neighbourhood neighbourhood = neighbourhoodDao.findById(id).orElseThrow();

        neighbourhood.setNeighbourhoodName(newName);

        neighbourhood = neighbourhoodDao.save(neighbourhood);

        return ResponseEntity.ok(neighbourhood);
    }

    @GetMapping("/find-neighbourhoods/{district}")
    public ResponseEntity<List<Neighbourhood>> findNeighbourhoodsByDistrict(@PathVariable District district) {

        List<Neighbourhood> nList = neighbourhoodDao.findNeighbourhoodsByDistrict(district);

        return ResponseEntity.ok(nList);
    }

    @PostMapping("/save-street")
    public ResponseEntity<Street> saveStreet(@RequestBody Street street) {

        street = streetDao.save(street);

        return new ResponseEntity<>(street, HttpStatus.CREATED);
    }

    @PatchMapping("/update-street/{id}")
    public ResponseEntity<Street> updateStreetName(@PathVariable Long id, @RequestBody String newName) {

        Street street = streetDao.findById(id).orElseThrow();

        street.setStreetName(newName);

        street = streetDao.save(street);

        return ResponseEntity.ok(street);
    }

    @GetMapping("/find-streets/{neighbourhood}")
    public ResponseEntity<List<Street>> findStreetsByNeighbourhood(@PathVariable Neighbourhood neighbourhood) {

        List<Street> sList = streetDao.findStreetsByNeighbourhood(neighbourhood);

        return ResponseEntity.ok(sList);
    }

    @PostMapping("/save-address")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address) {

        address = addressDao.save(address);

        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-address/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressDao.deleteById(id);
    }

    @GetMapping("/find-address/{id}")
    public ResponseEntity<Address> findAddressById(@PathVariable Long id) {

        Address address = addressDao.findById(id).orElseThrow();

        return ResponseEntity.ok(address);
    }
}