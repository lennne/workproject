package com.example.workproject;

public class Services {
    private String name;
    private String value;
    private Boolean expiring;

    public Services() {
        this.name = name;
        this.value = value;
        this.expiring = expiring;
    }

    public Services(String name, String value, Boolean expiring) {
        this.name = name;
        this.value = value;
        this.expiring = expiring;
    }

    public String getServices_name() {
        return name;
    }

    public String getServices_value() {
        return value;
    }

    public Boolean getServices_expiring() {
        return expiring;
    }

}
