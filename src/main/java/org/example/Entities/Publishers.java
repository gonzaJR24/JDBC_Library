package org.example.Entities;

public class Publishers {
    public String pubId, pubName, city, state, country;

    public Publishers() {
        this.pubId = "";
        this.pubName = "";
        this.city = "";
        this.state = "";
        this.country = "";
    }

    public Publishers(String pubId, String pubName, String city, String state, String country) {
        this.pubId = pubId;
        this.pubName = pubName;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}
