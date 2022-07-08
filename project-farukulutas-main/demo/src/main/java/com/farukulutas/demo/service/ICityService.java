package com.farukulutas.demo.service;

import com.farukulutas.demo.entity.City;
import org.json.simple.parser.ParseException;
import java.time.LocalDate;

public interface ICityService {

    String getCityInfo(String cityName, LocalDate startDate, LocalDate endDate) throws ParseException;

    String findCityCoordByName(String cityName );

    String findAirPollution(City newCity );

    String getResponse(String urlString);

}