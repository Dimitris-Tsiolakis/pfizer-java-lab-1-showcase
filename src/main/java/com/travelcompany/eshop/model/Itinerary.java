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

    @Override
    public String toString() {
        return "Itinerary{" +
                "departureCode=" + departureCode +
                ", destinationCode=" + destinationCode +
                ", departureDate='" + departureDate + '\'' +
                ", airline='" + airline + '\'' +
                ", basePrice=" + basePrice +
                "} " + super.toString();
    }

    public AirportCode getDepartureCode() {
        return departureCode;
    }

    public void setDepartureCode(AirportCode departureCode) {
        this.departureCode = departureCode;
    }

    public AirportCode getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(AirportCode destinationCode) {
        this.destinationCode = destinationCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }
}
