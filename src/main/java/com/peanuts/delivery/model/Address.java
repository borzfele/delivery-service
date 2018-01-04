package com.peanuts.delivery.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Address {

    private String city;
    private String zipcode;
    private String address;

    public Address() {
    }

    public Address(String city, String zipcode, String address) {
        this.city = city;
        this.zipcode = zipcode;
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
