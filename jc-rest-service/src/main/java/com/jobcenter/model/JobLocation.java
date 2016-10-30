package com.jobcenter.model;

import org.springframework.data.annotation.Id;

/**
 * Created on 10/29/2016.
 */
public class JobLocation {

    private String address;
    private String city;
    private String zipCode;

    public JobLocation() {
    }

    public JobLocation(String address, String city, String zipCode) {
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
