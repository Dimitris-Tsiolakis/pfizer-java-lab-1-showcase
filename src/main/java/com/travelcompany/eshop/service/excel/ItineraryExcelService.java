package com.travelcompany.eshop.service.excel;

import com.travelcompany.eshop.model.Itinerary;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ItineraryExcelService implements AbstractExcelService<Itinerary> {

    private static final Logger logger = LoggerFactory.getLogger(ItineraryExcelService.class);

    @Override
    public List<Itinerary> readFromFile(String filePath) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean storeToFile(List<Itinerary> itineraries, String filePath) {
        try (XSSFWorkbook workbook = new XSSFWorkbook();
             FileOutputStream outputStream = new FileOutputStream(filePath)) {
            logger.info("Writing multiple itineraries to Excel");
            XSSFSheet sheet = workbook.createSheet("Itineraries");

            int rowIndex = 0;

            for (Itinerary itinerary : itineraries) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(itinerary.getDepartureCode().getCode());
                row.createCell(1).setCellValue(itinerary.getDestinationCode().getCode());
                row.createCell(2).setCellValue(itinerary.getDepartureDate());
                row.createCell(3).setCellValue(itinerary.getBasePrice().doubleValue());
                row.createCell(4).setCellValue(itinerary.getAirline());
            }

            workbook.write(outputStream);

            return true;
        } catch (IOException ioException) {
            logger.error("", ioException);
            return false;
        }
    }
}
