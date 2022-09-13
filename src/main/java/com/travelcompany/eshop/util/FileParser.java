package com.travelcompany.eshop.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    public static List<String> parse(String filepath){
        ArrayList<String> stringList = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(filepath))){
            String line;
            while((line = bufferedReader.readLine()) != null){
                stringList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }
}
