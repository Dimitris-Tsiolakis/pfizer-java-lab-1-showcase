package com.travelcompany.eshop.factory;

import com.travelcompany.eshop.model.AirportCode;

import java.util.ArrayList;
import java.util.List;

public class AirportCodeFactory implements AbstractFactory<AirportCode> {
    @Override
    public List<AirportCode> parseList(List<String> lines) {
        List<AirportCode> airportCodes = new ArrayList<>();
        for (String line : lines) {
            String airportCodeStr = line;
            AirportCode airportCode = new AirportCode(airportCodeStr);
            airportCodes.add(airportCode);
        }
        return airportCodes;
    }
}
