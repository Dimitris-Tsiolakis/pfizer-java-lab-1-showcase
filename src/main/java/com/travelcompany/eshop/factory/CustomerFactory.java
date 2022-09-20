package com.travelcompany.eshop.factory;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.enumeration.CustomerCategory;

import java.util.ArrayList;
import java.util.List;

public class CustomerFactory implements AbstractFactory<Customer> {
    @Override
    public List<Customer> parseList(List<String> strings) {
        // validation missing, no checks for null
        ArrayList<Customer> customers = new ArrayList<>();
        for (String line : strings) {
            String[] splitLine = line.split(",");
            String name = splitLine[0];
            String email = splitLine[1];
            String address = splitLine[2];
            String nationality = splitLine[3];
            String category = splitLine[4];
            customers.add(new Customer(name, email, address, nationality, CustomerCategory.valueOf(category.toUpperCase())));
        }
        return customers;
    }
}
