package com.travelcompany.eshop.factory;

import com.travelcompany.eshop.model.AirportCode;
import com.travelcompany.eshop.model.Itinerary;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates itinerary objects from a set of lines
 */
public class ItineraryFactory implements AbstractFactory<Itinerary>{
    public List<Itinerary> parseList(List<String> lines) {
        List<Itinerary> itineraries = new ArrayList<>();
        for (String line : lines) {
            final String[] values = line.split(",");
            AirportCode departureAirport = new AirportCode(values[0]);
            AirportCode destinationAirport =  new AirportCode(values[1]);
            String departureDate = values[2];
            String airline = values[3];
            BigDecimal basePrice = new BigDecimal(values[4]);
            Itinerary itinerary = new Itinerary(departureAirport, destinationAirport, departureDate, airline, basePrice);
            itineraries.add(itinerary);
        }
        return itineraries;
    }
}
