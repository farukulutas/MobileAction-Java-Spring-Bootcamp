package com.farukulutas.demo.service;

public interface IAQIPollutantsService {

    // AQI CO (8 hr)
    String calculateCO(String co);

    // AQI O3 (8 hr)
    String calculateO3(String o3);

    // AQI SO2 (24 hr)
    String calculateSO2(String so2);
}