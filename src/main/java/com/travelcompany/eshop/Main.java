package com.travelcompany.eshop;

import com.travelcompany.eshop.factory.AirportCodeFactory;
import com.travelcompany.eshop.factory.CustomerFactory;
import com.travelcompany.eshop.factory.ItineraryFactory;
import com.travelcompany.eshop.model.AirportCode;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.Ticket;
import com.travelcompany.eshop.model.enumeration.PaymentMethod;
import com.travelcompany.eshop.service.PriceComputeService;
import com.travelcompany.eshop.service.TicketService;
import com.travelcompany.eshop.service.excel.AirportCodeExcelService;
import com.travelcompany.eshop.service.excel.CustomerExcelService;
import com.travelcompany.eshop.service.excel.ItineraryExcelService;
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

        logger.info("Writing multiple customers to Excel");
        CustomerExcelService customerExcelService = new CustomerExcelService();
        customerExcelService.storeToFile(customersFromFactory, "customersExcel.xlsx");

        logger.info("Writing multiple itineraries to Excel");
        ItineraryExcelService itineraryExcelService = new ItineraryExcelService();
        itineraryExcelService.storeToFile(itinerariesFromFactory, "itinerariesExcel.xlsx");

        logger.info("Writing multiple airport codes to Excel");
        AirportCodeExcelService airportCodeExcelService = new AirportCodeExcelService();
        airportCodeExcelService.storeToFile(airportCodesFromFactory, "airportCodesExcel.xlsx");

        logger.info("Publishing ticket 1");
        Customer customer1 = customersFromFactory.get(0);
        Itinerary itinerary1 = itinerariesFromFactory.get(0);
        TicketService ticketService = new TicketService(new PriceComputeService());
        Ticket ticket1 = ticketService.publishTicket(customer1, itinerary1, PaymentMethod.CREDIT);
        logger.info("{}", ticket1);
    }
}
