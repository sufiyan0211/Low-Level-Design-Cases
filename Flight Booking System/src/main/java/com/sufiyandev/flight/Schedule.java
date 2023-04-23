package com.sufiyandev.flight;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private Flight flight;
    private Airport arrivalAirport;
    private Airport destinationAirport;
    private Timestamp arrivalTime;
    private Timestamp destinationTime;
    private FlightStatus flightStatus;
    private List<FlightSeat> flightSeatWithFare;

    public Schedule(Flight flight, Airport arrivalAirport,
                    Airport destinationAirport, Timestamp arrivalTime,
                    Timestamp destinationTime, FlightStatus flightStatus,
                    List<FlightSeat> flightSeatWithFare) {
        this.flight = flight;
        this.arrivalAirport = arrivalAirport;
        this.destinationAirport = destinationAirport;
        this.arrivalTime = arrivalTime;
        this.destinationTime = destinationTime;
        this.flightStatus = flightStatus;
        this.flightSeatWithFare = flightSeatWithFare;
    }

    public Seat getSeatBySeatNumber(int seatNumber) {
        for(FlightSeat flightSeat : flightSeatWithFare) {
            return flightSeat;
        }
        return null;
    }
    public Flight getFlight() {
        return flight;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public Timestamp getDestinationTime() {
        return destinationTime;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public List<FlightSeat> getFlightSeatWithFare() {
        return flightSeatWithFare;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDestinationTime(Timestamp destinationTime) {
        this.destinationTime = destinationTime;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public void setFlightSeatWithFare(List<FlightSeat> flightSeatWithFare) {
        this.flightSeatWithFare = flightSeatWithFare;
    }

    public void setFlightSeatWithFare() {
        this.flightSeatWithFare = new ArrayList<>();
        for(int i=0;i< flight.getSeatCapacity();i++) {
            FlightSeat flightSeat = new FlightSeat();
            flightSeat.setSeatNumber(i);
            flightSeat.setSeatStatus(SeatStatus.Available);
            flightSeatWithFare.add(flightSeat);
        }
    }
}
