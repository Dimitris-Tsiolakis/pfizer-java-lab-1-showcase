package com.travelcompany.eshop.factory;

import java.util.List;

public interface AbstractFactory<T> {
    List<T> parseList(List<String> strings);
}
