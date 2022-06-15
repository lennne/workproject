package com.example.workproject;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

    public class DeviceTwo implements Serializable {
        @SerializedName("title")
        private String title;

        @SerializedName("items")
        private ItemsTwo[] items;

        public DeviceTwo() {
            this.title = title;
            this.items = items;
        }


        public DeviceTwo(String title, ItemsTwo[] items) {
            this.title = title;
            this.items = items;
        }

        public String getTitle() {
            return title;
        }

        public ItemsTwo[] getItems() {
            return items;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setItems(ItemsTwo[] items) {
            this.items = items;
        }




    }
