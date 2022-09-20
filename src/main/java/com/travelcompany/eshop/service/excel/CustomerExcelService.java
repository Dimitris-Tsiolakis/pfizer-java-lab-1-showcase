package com.travelcompany.eshop.service.excel;

import com.travelcompany.eshop.model.Customer;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class CustomerExcelService implements AbstractExcelService<Customer> {

    @Override
    public List<Customer> readFromFile(String filePath) {
        try(FileInputStream fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)){
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
            ioException.printStackTrace();
            return false;
        }
    }
}
