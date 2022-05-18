package com.example.workproject;

public class IconColors {
    private String moving;
    private String stopped;
    private String offline;
    private String engine;

    public IconColors() {
        this.moving = moving;
        this.stopped = stopped;
        this.offline = offline;
        this.engine = engine;
    }


    public IconColors(String moving, String stopped, String offline, String engine) {
        this.moving = moving;
        this.stopped = stopped;
        this.offline = offline;
        this.engine = engine;
    }

    public String getmoving() {
        return moving;
    }

    public String getstopped() {
        return stopped;
    }

    public String getoffline() {
        return offline;
    }

    public String getengine() {
        return engine;
    }
}
