package com.example.workproject2;

import com.google.gson.annotations.SerializedName;

public class Items {
    @SerializedName("sensor")
    private Sensor[] sensor;
    @SerializedName("services")
    private Services[] services;
    @SerializedName("tail")
    private Tail[] tail;
    @SerializedName("device_data")
    private Devicedata device_data;
    @SerializedName("icon_colors")
    private IconColors icon_colors;



    private Integer id;
    private String name;
    private String online;
    private String alarm;
    private String time;
    private Integer timestamp;
    private Integer acktimestamp;
    private Integer speed;
    private Float lat;
    private Float lng;
    private String course;
    private String power;
    private Integer altitude;
    private String address;
    private String protocol;
    private String driver;

    private String distance_unit_hour;

    private String unit_of_distance;
    private String unit_of_altitude;
    private String unit_of_capacity;
    private String stop_duration;
    private Integer moved_timestamp;
    private Boolean engine_status;
    private String icon_type;
    private String icon_color;



    public Items() {
        this.distance_unit_hour = distance_unit_hour;
        this.unit_of_distance = unit_of_distance;
        this.unit_of_altitude = unit_of_altitude;
        this.unit_of_capacity = unit_of_capacity;
        this.stop_duration = stop_duration;
        this.moved_timestamp = moved_timestamp;
        this.engine_status = engine_status;
        this.icon_type = icon_type;
        this.icon_color = icon_color;
        this.sensor = sensor;
        this.services = services;
        this.tail = tail;
        this.device_data = device_data;
        this.icon_colors = icon_colors;
        this.id = id;
        this.name = name;
        this.online = online;
        this.alarm = alarm;
        this.time = time;
        this.timestamp = timestamp;
        this.acktimestamp = acktimestamp;
        this.speed = speed;
        this.lat = lat;
        this.lng = lng;
        this.course = course;
        this.power = power;
        this.altitude = altitude;
        this.address = address;
        this.protocol = protocol;
        this.driver = driver;
    }


    public Items( String distance_unit_hour, String unit_of_distance, String unit_of_altitude, String unit_of_capacity, String stop_duration,
                  Integer moved_timestamp, Boolean engine_status, String icon_type, String icon_color,Sensor[] sensor, Services[] services, Tail[] tail, Devicedata device_data, IconColors icon_colors, Integer id, String name, String online, String alarm,
                 String time, Integer timestamp, Integer acktimestamp, Integer speed, Float lat, Float lng, String course, String power, Integer altitude, String address,
                 String protocol, String driver) {

        this.distance_unit_hour = distance_unit_hour;
        this.unit_of_distance = unit_of_distance;
        this.unit_of_altitude = unit_of_altitude;
        this.unit_of_capacity = unit_of_capacity;
        this.stop_duration = stop_duration;
        this.moved_timestamp = moved_timestamp;
        this.engine_status = engine_status;
        this.icon_type = icon_type;
        this.icon_color = icon_color;
        this.sensor = sensor;
        this.services = services;
        this.tail = tail;
        this.device_data = device_data;
        this.icon_colors = icon_colors;
        this.id = id;
        this.name = name;
        this.online = online;
        this.alarm = alarm;
        this.time = time;
        this.timestamp = timestamp;
        this.acktimestamp = acktimestamp;
        this.speed = speed;
        this.lat = lat;
        this.lng = lng;
        this.course = course;
        this.power = power;
        this.altitude = altitude;
        this.address = address;
        this.protocol = protocol;
        this.driver = driver;


    }

    public IconColors getIcon_colors() {
        return icon_colors;
    }

    public void setIcon_colors(IconColors icon_colors) {
        this.icon_colors = icon_colors;
    }

    public Sensor[] getSensor() {
        return sensor;
    }

    public void setSensor(Sensor[] sensor) {
        this.sensor = sensor;
    }

    public Services[] getServices() {
        return services;
    }

    public void setServices(Services[] services) {
        this.services = services;
    }

    public Tail[] getTail() {
        return tail;
    }

    public void setTail(Tail[] tail) {
        this.tail = tail;
    }

    public Devicedata getDevice_data() {
        return device_data;
    }

    public void setDevice_data(Devicedata device_data) {
        this.device_data = device_data;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOnline() {
        return online;
    }

    public String getAlarm() {
        return alarm;
    }

    public String getTime() {
        return time;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public Integer getAcktimestamp() {
        return acktimestamp;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Float getLat() {
        return lat;
    }

    public Float getLng() {
        return lng;
    }

    public String getCourse() {
        return course;
    }

    public String getPower() {
        return power;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public String getAddress() {
        return address;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getDriver() {
        return driver;
    }

    public void setDistance_unit_hour(String distance_unit_hour) {
        this.distance_unit_hour = distance_unit_hour;
    }

    public void setUnit_of_distance(String unit_of_distance) {
        this.unit_of_distance = unit_of_distance;
    }

    public void setUnit_of_altitude(String unit_of_altitude) {
        this.unit_of_altitude = unit_of_altitude;
    }

    public void setUnit_of_capacity(String unit_of_capacity) {
        this.unit_of_capacity = unit_of_capacity;
    }

    public void setStop_duration(String stop_duration) {
        this.stop_duration = stop_duration;
    }

    public void setMoved_timestamp(Integer moved_timestamp) {
        this.moved_timestamp = moved_timestamp;
    }

    public void setEngine_status(Boolean engine_status) {
        this.engine_status = engine_status;
    }

    public void setIcon_type(String icon_type) {
        this.icon_type = icon_type;
    }

    public void setIcon_color(String icon_color) {
        this.icon_color = icon_color;
    }

    public String getDistance_unit_hour() {
        return distance_unit_hour;
    }

    public String getUnit_of_distance() {
        return unit_of_distance;
    }

    public String getUnit_of_altitude() {
        return unit_of_altitude;
    }

    public String getUnit_of_capacity() {
        return unit_of_capacity;
    }

    public String getStop_duration() {
        return stop_duration;
    }

    public Integer getMoved_timestamp() {
        return moved_timestamp;
    }

    public Boolean getEngine_status() {
        return engine_status;
    }

    public String getIcon_type() {
        return icon_type;
    }

    public String getIcon_color() {
        return icon_color;
    }




}
