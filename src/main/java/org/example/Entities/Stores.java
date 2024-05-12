package org.example.Entities;

public class Stores {
    public String storeId, storeName, storeAddress, city, state, zip;

    public Stores() {
        this.storeId = "";
        this.storeName = "";
        this.storeAddress = "";
        this.city = "";
        this.state = "";
        this.zip = "";
    }

    public Stores(String storeId, String storeName, String storeAddress, String city, String state, String zip) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
