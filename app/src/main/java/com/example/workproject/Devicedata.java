package com.example.workproject;

import com.google.gson.annotations.SerializedName;

public class Devicedata {

    @SerializedName("pivot")
    private Pivot pivot;
    @SerializedName("users")
    private Users users;



    private String id;
    private String user_id;
    private String traccar_device_id;
    private String icon_id;
    private String active;
    private String deleted;
    private String name;
    private String imei;
    private String fuel_measurement_id;
    private String fuel_quantity;
    private String fuel_price;
    private String fuel_per_km;
    private String sim_number;
    private String device_model;
    private String plate_number;
    private String vin;
    private String registration_number;
    private String object_owner;
    private String expiration_date;
    private String tail_color;
    private String tail_length;
    private String engine_hours;
    private String detect_engine;
    private String min_moving_speed;
    private String min_fuel_fillings;
    private String snap_to_road;
    private String created_at;
    private String updated_at;

    public Devicedata() {
        this.pivot = pivot;
        this.users = users;
        this.id = id;
        this.user_id = user_id;
        this.traccar_device_id = traccar_device_id;
        this.icon_id = icon_id;
        this.active = active;
        this.deleted = deleted;
        this.name = name;
        this.imei = imei;
        this.fuel_measurement_id = fuel_measurement_id;
        this.fuel_quantity = fuel_quantity;
        this.fuel_price = fuel_price;
        this.fuel_per_km = fuel_per_km;
        this.sim_number = sim_number;
        this.device_model = device_model;
        this.plate_number = plate_number;
        this.vin = vin;
        this.registration_number = registration_number;
        this.object_owner = object_owner;
        this.expiration_date = expiration_date;
        this.tail_color = tail_color;
        this.tail_length = tail_length;
        this.engine_hours = engine_hours;
        this.detect_engine = detect_engine;
        this.min_moving_speed = min_moving_speed;
        this.min_fuel_fillings = min_fuel_fillings;
        this.snap_to_road = snap_to_road;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Devicedata(Pivot pivot, Users users, String id, String user_id, String traccar_device_id, String icon_id, String active, String deleted, String name, String imei,
                      String fuel_measurement_id, String fuel_quantity, String fuel_price, String fuel_per_km, String sim_number, String device_model, String plate_number,
                      String vin, String registration_number, String object_owner, String expiration_date, String tail_color, String tail_length,
                      String engine_hours, String detect_engine, String min_moving_speed, String min_fuel_fillings, String snap_to_road, String created_at, String updated_at) {
        this.pivot = pivot;
        this.users = users;
        this.id = id;
        this.user_id = user_id;
        this.traccar_device_id = traccar_device_id;
        this.icon_id = icon_id;
        this.active = active;
        this.deleted = deleted;
        this.name = name;
        this.imei = imei;
        this.fuel_measurement_id = fuel_measurement_id;
        this.fuel_quantity = fuel_quantity;
        this.fuel_price = fuel_price;
        this.fuel_per_km = fuel_per_km;
        this.sim_number = sim_number;
        this.device_model = device_model;
        this.plate_number = plate_number;
        this.vin = vin;
        this.registration_number = registration_number;
        this.object_owner = object_owner;
        this.expiration_date = expiration_date;
        this.tail_color = tail_color;
        this.tail_length = tail_length;
        this.engine_hours = engine_hours;
        this.detect_engine = detect_engine;
        this.min_moving_speed = min_moving_speed;
        this.min_fuel_fillings = min_fuel_fillings;
        this.snap_to_road = snap_to_road;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Pivot getPivot() {
        return pivot;
    }

    public void setPivot(Pivot pivot) {
        this.pivot = pivot;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getuser_id() {
        return user_id;
    }

    public String gettraccar_device_id() {
        return traccar_device_id;
    }

    public String geticon_id() {
        return icon_id;
    }

    public String getactive() {
        return active;
    }

    public String getdeleted() {
        return deleted;
    }

    public String getname() {
        return name;
    }

    public String getimei() {
        return imei;
    }

    public String getfuel_measurement_id() {
        return fuel_measurement_id;
    }

    public String getfuel_quantity() {
        return fuel_quantity;
    }

    public String getfuel_price() {
        return fuel_price;
    }

    public String getfuel_per_km() {
        return fuel_per_km;
    }

    public String getsim_number() {
        return sim_number;
    }

    public String getdevice_model() {
        return device_model;
    }

    public String getplate_number() {
        return plate_number;
    }

    public String getvin() {
        return vin;
    }

    public String getregistration_number() {
        return registration_number;
    }

    public String getobject_owner() {
        return object_owner;
    }

    public String getexpiration_date() {
        return expiration_date;
    }

    public String gettail_color() {
        return tail_color;
    }

    public String gettail_length() {
        return tail_length;
    }

    public String getengine_hours() {
        return engine_hours;
    }

    public String getdetect_engine() {
        return detect_engine;
    }

    public String getmin_moving_speed() {
        return min_moving_speed;
    }

    public String getmin_fuel_fillings() {
        return min_fuel_fillings;
    }

    public String getsnap_to_road() {
        return snap_to_road;
    }

    public String getcreated_at() {
        return created_at;
    }

    public String getupdated_at() {
        return updated_at;
    }
    public String getid() {
        return id;
    }



}
