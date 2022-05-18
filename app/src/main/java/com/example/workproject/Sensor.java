package com.example.workproject;

public class Sensor {
    private String name;
    private String value;
    private String show_in_popup;


    public Sensor() {
        this.name = name;
        this.value = value;
        this.show_in_popup = show_in_popup;
    }


    public Sensor(String name, String value, String show_in_popup) {
        this.name = name;
        this.value = value;
        this.show_in_popup = show_in_popup;
    }

    public String getSensors_name() {
        return name;
    }

    public String getSensors_value() {
        return value;
    }

    public String getSensors_show_in_popup() {
        return show_in_popup;
    }
}
