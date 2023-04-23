package com.sufiyandev.flight;

import com.sufiyandev.user.Nationality;

public class Location {
    private String city;
    private Nationality nationality;
    private String address;
    private String postalCode;

    public Location(String city) {
        this.city = city;
    }
}
