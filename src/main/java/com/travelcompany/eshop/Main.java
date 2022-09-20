package com.travelcompany.eshop;

import com.travelcompany.eshop.factory.AirportCodeFactory;
import com.travelcompany.eshop.factory.CustomerFactory;
import com.travelcompany.eshop.factory.ItineraryFactory;
import com.travelcompany.eshop.model.AirportCode;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.util.FileParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Loading customers from CSV");
        List<String> customersAsLines = FileParser.load("csvFiles/customers.csv");
        CustomerFactory customerFactory = new CustomerFactory();
        List<Customer> customersFromFactory = customerFactory.parseList(customersAsLines);
        customersFromFactory.forEach(customer -> logger.info("{}", customer));

        logger.info("Loading itineraries from CSV");
        List<String> itinerariesAsLines = FileParser.load("csvFiles/itineraries.csv");
        ItineraryFactory itineraryFactory = new ItineraryFactory();
        List<Itinerary> itinerariesFromFactory = itineraryFactory.parseList(itinerariesAsLines);
        itinerariesFromFactory.forEach(itinerary -> logger.info("{}", itinerary));

        logger.info("Loading airport codes from CSV");
        List<String> airportCodesAsLines = FileParser.load("csvFiles/airport_codes.csv");
        AirportCodeFactory airportCodeFactory = new AirportCodeFactory();
        List<AirportCode> airportCodesFromFactory = airportCodeFactory.parseList(airportCodesAsLines);
        airportCodesFromFactory.forEach(airportCode -> logger.info("{}", airportCode));

    }
}
