package com.travelcompany.eshop.service;

import java.util.List;

public interface AbstractExcelService<T> {
    List<T> readFromFile(String filePath);
    boolean storeToFile();
}
