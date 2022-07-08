package com.farukulutas.demo.controller;

import com.farukulutas.demo.service.CityService;
import net.minidev.json.parser.ParseException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    // parameter is CITY (manda) and DATE (default: last week)
    // CITIES:  London, Barcelona, Ankara, Tokyo ve Mumbai
    // you will check whether the city in the given date is in db or not,
    // if not use API, and store it. (date may be partially taken from db and api)
    // co, o3 and so2 info will be stored
    // by using AQI table, classify the elements by good, satisfactory,...
    // RESPONSE WILL BE IN JSON FORMAT

    @PostMapping("/getcityinfo")
    public ResponseEntity<String> getCityInfo(@RequestParam String cityName,
                                              @RequestParam(required = false, defaultValue = "")  @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
                                              @RequestParam(required = false, defaultValue = "")  @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate )
            throws ParseException, org.json.simple.parser.ParseException {

        String response = cityService.getCityInfo( cityName, startDate, endDate);

        return ResponseEntity.ok( response);
    }
}
