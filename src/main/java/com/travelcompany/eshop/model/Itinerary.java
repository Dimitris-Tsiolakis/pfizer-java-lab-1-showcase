package com.travelcompany.eshop.model;

import java.math.BigDecimal;
import java.util.Date;

public class Itinerary extends BaseEntity {
    private AirportCode departureCode;
    private AirportCode destinationCode;
    private String departureDate;
    private String airline;
    private BigDecimal basePrice;

    public Itinerary(AirportCode departureCode, AirportCode destinationCode, String departureDate, String airline, BigDecimal basePrice) {
        this.departureCode = departureCode;
        this.destinationCode = destinationCode;
        this.departureDate = departureDate;
        this.airline = airline;
        this.basePrice = basePrice;
    }
}
