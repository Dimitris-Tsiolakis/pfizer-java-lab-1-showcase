package com.travelcompany.eshop.service;

import java.util.List;

public interface AbstractExcelService<T> {
    List<T> readFile(String filePath);
    boolean storeToFile();
}
