package com.sufiyandev.flight;


import java.util.List;

public class Airport {
    private String airportName;
    private Location location;

    public Airport(String airportName, Location location) {
        this.airportName = airportName;
        this.location = location;
    }

    public Airport() {
    }

    public Location getLocation() {
        return location;
    }
}
