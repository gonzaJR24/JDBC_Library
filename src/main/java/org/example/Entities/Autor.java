package org.example.Entities;

public class Autor {
    public String auId, auLname, auFname, phone, address, city, state, zip;
    public int contract;

    public Autor() {
        this.auId = "";
        this.auLname = "";
        this.auFname = "";
        this.phone = "";
        this.address = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.contract = 0;
    }

    public Autor(String auId, String auLname, String auFname, String phone, String address, String city, String state, String zip, int contract) {
        this.auId = auId;
        this.auLname = auLname;
        this.auFname = auFname;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "auId='" + auId + '\'' +
                ", auLname='" + auLname + '\'' +
                ", auFname='" + auFname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", contract=" + contract +
                '}';
    }
}
