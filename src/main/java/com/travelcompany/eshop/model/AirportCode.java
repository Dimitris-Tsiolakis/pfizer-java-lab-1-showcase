package com.travelcompany.eshop.model;

public class AirportCode extends BaseEntity {
    private String code;

    public AirportCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "AirportCode{" +
                "code='" + code + '\'' +
                "} " + super.toString();
    }
}
