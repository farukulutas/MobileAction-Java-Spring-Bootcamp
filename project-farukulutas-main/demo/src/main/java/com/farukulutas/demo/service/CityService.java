package com.farukulutas.demo.service;

import com.farukulutas.demo.dao.CityDao;
import com.farukulutas.demo.entity.City;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityDao cityDao;
    private final String APIKey = "44dd77d44c2779bbc88fc7989e732576";

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
        JSONObject ob = (JSONObject) new JSONParser().parse(response);
        JSONObject main = (JSONObject) ob.get("main");
        JSONObject coord = (JSONObject) ob.get("coord");
        JSONArray weatherArray = (JSONArray) ob.get("weather");
        JSONObject weatherObj = (JSONObject) weatherArray.get(0);

        // create new city
        City newCity = new City();
        newCity.setCityName(cityName);
        newCity.setStartDate(startDate);
        newCity.setEndDate(endDate);
        newCity.setLat( coord.get("lat").toString() );
        newCity.setLon( coord.get("lon").toString() );

        // call api
        // http://api.openweathermap.org/data/2.5/air_pollution/history?lat= + newCity.getLat() + &lon= + newCity.getLon() + &start= + 1606223802 + &end= + 1606482999 + &appid= + APIKey

        return null;
    }

    public String findCityCoordByName(String cityName ) {
        return getResponse("http://api.openweathermap.org/geo/1.0/direct?q=" + cityName + "&limit=5&appid=" + APIKey);
    }

    private String getResponse(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return content.toString();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            return "Error: " + e.toString();
        }
    }

}