package com.farukulutas.demo.service;

import com.farukulutas.demo.dao.CityDao;
import com.farukulutas.demo.entity.AQIPollutant;
import com.farukulutas.demo.entity.City;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class CityService implements ICityService {
    private final CityDao cityDao;
    private final String APIKey = "44dd77d44c2779bbc88fc7989e732576";
    private final AQIPollutantsService aqiPollutantsService;

    public String getCityInfo(String cityName, LocalDate startDate, LocalDate endDate) throws ParseException {
        // update start and end date
        if ( startDate.equals("") && endDate.equals("") ) {
            endDate = LocalDate.now();
            startDate = endDate.minus(1, ChronoUnit.WEEKS);
        }

        // find city if exists
        City city = cityDao.findCityByName( cityName);

        // if city exist in db
        if ( city != null ) {
            // check date of records
            if ( city.getEndDate().isBefore( startDate) || city.getStartDate().isAfter(endDate) ) {
                // go api

            }

        }

        // get api response
        String response = findCityCoordByName(cityName);

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response);

        String lat = (String) jsonObject.get("lat");
        String lon = (String) jsonObject.get("lon");

        // create new city
        City newCity = new City();
        newCity.setCityName(cityName);
        newCity.setStartDate(startDate);
        newCity.setEndDate(endDate);
        newCity.setLat(lat);
        newCity.setLon(lon);

        // call air pollution api
        String apiResponse = findAirPollution(newCity);
        jsonObject = (JSONObject) parser.parse(apiResponse);

        String co = (String) jsonObject.get("co");
        String o3 = (String) jsonObject.get("o3");
        String so2 = (String) jsonObject.get("so2");

        co = aqiPollutantsService.calculateCO( co);
        o3 = aqiPollutantsService.calculateO3( o3);
        so2 = aqiPollutantsService.calculateSO2( so2);

        // save city to db
        AQIPollutant newAQI = new AQIPollutant();
        newAQI.setCo( co);
        newAQI.setO3( o3);
        newAQI.setSo2( so2);
        //newAQI.setDate( );

        // return info in json format
        return null;
    }

    public String findCityCoordByName(String cityName ) {
        return getResponse("http://api.openweathermap.org/geo/1.0/direct?q=" + cityName + "&limit=5&appid=" + APIKey);
    }

    public String findAirPollution(City newCity ) {
        // create a LocalTime object
        LocalTime time = LocalTime.parse("20:12:32");

        // create ZoneId
        ZoneOffset zone = ZoneOffset.of("UTC");

        return getResponse("http://api.openweathermap.org/data/2.5/air_pollution/history?lat=" + newCity.getLat() + "&lon=" + newCity.getLon() + "&start=" + newCity.getStartDate().toEpochSecond(time, zone) + "&end=" + newCity.getEndDate().toEpochSecond(time, zone) + "&appid=" + APIKey);
    }

    public String getResponse(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return content.toString();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return "Error: " + e;
        }
    }

}