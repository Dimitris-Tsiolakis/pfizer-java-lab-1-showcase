package com.travelcompany.eshop;

import com.travelcompany.eshop.util.FileParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        final List<String> parsedList = FileParser.parse("csvFiles/airport_codes.csv");
        for (String s : parsedList) {
            logger.info(s);
        }
    }
}
