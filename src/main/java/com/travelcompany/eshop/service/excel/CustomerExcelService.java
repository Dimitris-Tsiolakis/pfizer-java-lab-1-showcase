package com.travelcompany.eshop.service.excel;

import com.travelcompany.eshop.model.Customer;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class CustomerExcelService implements AbstractExcelService<Customer> {

    private static final Logger logger = LoggerFactory.getLogger(CustomerExcelService.class);
    // example headers and how they would be applied within an Excel file
    private final String[] headers = {"ID", "Name", "Email", "Address", "Nationality", "Category",};


    @Override
    public List<Customer> readFromFile(String filePath) {
        try(FileInputStream fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)){
            logger.info("Writing multiple customers to Excel");

            final XSSFSheet sheet = workbook.getSheetAt(0);

            final XSSFRow row = sheet.getRow(0);
            final String stringCellValue = row.getCell(0).getStringCellValue();
            // todo, actually read from an excel file
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return List.of();
    }

    @Override
    public boolean storeToFile(List<Customer> customers, String filePath) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook()){

            XSSFSheet sheet = workbook.createSheet("Customers");

            int rowIndex = 0;
            Row header = sheet.createRow(rowIndex++);
            header.createCell(0).setCellValue(headers[0]);
            header.createCell(1).setCellValue(headers[1]);
            header.createCell(2).setCellValue(headers[2]);
            header.createCell(3).setCellValue(headers[3]);
            header.createCell(4).setCellValue(headers[4]);
            header.createCell(5).setCellValue(headers[5]);


            for (Customer customer : customers) {
                XSSFRow row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(customer.getName()); //A
                row.createCell(1).setCellValue(customer.getEmail()); //B
                row.createCell(2).setCellValue(customer.getAddress());
                row.createCell(3).setCellValue(customer.getNationality());
                row.createCell(4).setCellValue(customer.getCategory().toString());
            }

            workbook.write(fileOutputStream);

            return true;
        } catch (IOException ioException) {
            logger.error("", ioException);
            return false;
        }
    }
}
