package com.sufiyandev.flight.dao;

import com.sufiyandev.flight.Flight;

import java.util.ArrayList;
import java.util.List;

public class Flights {
    private List<Flight> flights;

    public Flights() {
        this.flights = new ArrayList<>();
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public Flight saveFlight(Flight flight) {
        flights.add(flight);
        return flight;
    }

    public Flight updateFlight(Flight oldFlight, Flight newFlight) {
        flights.remove(oldFlight);
        flights.add(newFlight);
        return newFlight;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
