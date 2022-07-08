package com.farukulutas.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AQIPollutantsService implements IAQIPollutantsService {

    // AQI CO (8 hr)
    public String calculateCO(String co) {
        double value = Double.parseDouble(co);

        if (value <= 1.0) {
            return "Good";
        }
        if (value <= 2.0) {
            return "Satisfactory";
        }
        if (value <= 10.0) {
            return "Moderate";
        }
        if (value <= 17.0) {
            return "Poor";
        }
        if (value <= 34.0) {
            return "Severe";
        }

        return "Hazardous";
    }

    // AQI O3 (8 hr)
    public String calculateO3(String o3) {
        double value = Double.parseDouble(o3);

        if (value <= 50.0) {
            return "Good";
        }
        if (value <= 100.0) {
            return "Satisfactory";
        }
        if (value <= 168.0) {
            return "Moderate";
        }
        if (value <= 208.0) {
            return "Poor";
        }
        if (value <= 748.0) {
            return "Severe";
        }

        return "Hazardous";
    }

    // AQI SO2 (24 hr)
    public String calculateSO2(String so2) {
        double value = Double.parseDouble(so2);

        if (value <= 40.0) {
            return "Good";
        }
        if (value <= 80.0) {
            return "Satisfactory";
        }
        if (value <= 380.0) {
            return "Moderate";
        }
        if (value <= 800.0) {
            return "Poor";
        }
        if (value <= 1600.0) {
            return "Severe";
        }

        return "Hazardous";
    }

}