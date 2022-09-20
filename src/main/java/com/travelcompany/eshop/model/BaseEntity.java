package com.travelcompany.eshop.model;

public abstract class BaseEntity {
    private long id;

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }
}
