package com.example.workproject;

public class Pivot {
    private String user_id;
    private String device_id;
    private String group_id;
    private String current_driver_id;
    private String active;
    private String timezone_id;

    public Pivot() {
        this.user_id = user_id;
        this.device_id = device_id;
        this.group_id = group_id;
        this.current_driver_id = current_driver_id;
        this.active = active;
        this.timezone_id = timezone_id;
    }

    public Pivot(String user_id, String device_id, String group_id, String current_driver_id, String active, String timezone_id) {
        this.user_id = user_id;
        this.device_id = device_id;
        this.group_id = group_id;
        this.current_driver_id = current_driver_id;
        this.active = active;
        this.timezone_id = timezone_id;
    }

    public String getuser_id() {
        return user_id;
    }

    public String getdevice_id() {
        return device_id;
    }

    public String getgroup_id() {
        return group_id;
    }

    public String getcurrent_driver_id() {
        return current_driver_id;
    }

    public String getactive() {
        return active;
    }

    public String gettimezone_id() {
        return timezone_id;
    }


}
