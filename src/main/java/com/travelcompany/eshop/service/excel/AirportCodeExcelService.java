package com.travelcompany.eshop.service.excel;

import com.travelcompany.eshop.model.AirportCode;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class AirportCodeExcelService implements AbstractExcelService<AirportCode> {

    private static final Logger logger = LoggerFactory.getLogger(AirportCodeExcelService.class);

    @Override
    public List<AirportCode> readFromFile(String filePath) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean storeToFile(List<AirportCode> airportCodes, String filePath) {
        try (XSSFWorkbook workbook = new XSSFWorkbook();
             FileOutputStream outputStream = new FileOutputStream(filePath)) {
            logger.info("Writing multiple airport codes to Excel");
            XSSFSheet sheet = workbook.createSheet("Airport Codes");

            int rowIndex = 0;
            for (AirportCode airportCode : airportCodes) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(airportCode.getCode());
            }

            workbook.write(outputStream);

            return true;
        } catch (IOException ioException) {
            logger.error("", ioException);
            return false;
        }
    }
}
