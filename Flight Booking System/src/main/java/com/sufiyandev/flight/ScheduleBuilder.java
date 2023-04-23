package com.sufiyandev.flight;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ScheduleBuilder {
    private Flight flight;
    private Airport arrivalAirport;
    private Airport destinationAirport;
    private Timestamp arrivalTime;
    private Timestamp destinationTime;
    private FlightStatus flightStatus;
    private List<FlightSeat> flightSeatWithFare;


    public ScheduleBuilder setFlight(Flight flight) {
        this.flight = flight;
        return this;
    }

    public ScheduleBuilder setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
        return this;
    }

    public ScheduleBuilder setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
        return this;
    }

    public ScheduleBuilder setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public ScheduleBuilder setDestinationTime(Timestamp destinationTime) {
        this.destinationTime = destinationTime;
        return this;
    }

    public ScheduleBuilder setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
        return this;
    }

    public ScheduleBuilder setFlightSeatWithFare(List<FlightSeat> flightSeatWithFare) {
        this.flightSeatWithFare = flightSeatWithFare;
        return this;
    }

    public Schedule build() {
        return new Schedule(flight, arrivalAirport, destinationAirport,
                arrivalTime, destinationTime, flightStatus, flightSeatWithFare);
    }
}
