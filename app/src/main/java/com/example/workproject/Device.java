package com.example.workproject;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Device implements Serializable {
    @SerializedName("title")
    private String title;

    @SerializedName("items")
    private Items[] items;

    public Device() {
        this.title = title;
        this.items = items;
    }


    public Device(String title, Items[] items) {
        this.title = title;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public Items[] getItems() {
        return items;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setItems(Items[] items) {
        this.items = items;
    }




}
