package com.travelcompany.eshop.service.excel;

import com.travelcompany.eshop.model.Customer;

import java.util.List;

public interface AbstractExcelService<T> {
    List<T> readFromFile(String filePath);
    boolean storeToFile(List<T> t, String filePath);
}
