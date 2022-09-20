package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class CustomerExcelService implements AbstractExcelService<Customer>{
    @Override
    public List<Customer> readFile(String filePath) {
        try(FileInputStream fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)){
            final XSSFSheet sheet = workbook.getSheetAt(0);

            final XSSFRow row = sheet.getRow(0);
            final String stringCellValue = row.getCell(0).getStringCellValue();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return List.of();
    }

    @Override
    public boolean storeToFile() {
        return false;
    }
}
