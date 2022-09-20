package com.travelcompany.eshop.model;

public abstract class BaseEntity {
    private long id;
    private static int counter = 0;

    public BaseEntity() {
        this.id = ++counter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }
}
