package com.sufiyandev.bookingSystem;

import com.sufiyandev.flight.*;
import com.sufiyandev.user.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    List<User> users;
    List<Flight> flights;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public BookingSystem() {
    }

    public BookingSystem(List<User> users, List<Flight> flights) {
        this.users = users;
        this.flights = flights;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> getFlights(Location arrival, Location destination, Timestamp arrivalTime) {
        List<Flight> requireFlights = new ArrayList<>();
        for (Flight flight: flights) {
            List<Schedule> flightSchedules = flight.getSchedules();
            for(Schedule flightSchedule: flightSchedules) {
                if(flightSchedule.getArrivalAirport().getLocation() == arrival &&
                        flightSchedule.getDestinationAirport().getLocation() == destination &&
                        flightSchedule.getArrivalTime() == arrivalTime) {
                    requireFlights.add(flight);
                }
            }
        }
        return requireFlights;
    }

    public boolean bookFlight(User user, Location arrival, Location destination, Timestamp arrivalTime, int seatNumber) {
        List<Flight> availableFights = getFlights(arrival, destination, arrivalTime);
        if(availableFights.isEmpty()) return false;
        Flight flight = availableFights.get(0);

        Flight updateFlight = flight.clone();
        List<FlightSeat> seats = updateFlight.getSchedule(flight.getFlightNumber()).getFlightSeatWithFare();
        for(FlightSeat seat : seats) {
            if(seat.getSeatNumber() == seatNumber) {
                seat.setUser(user);
                seat.setSeatStatus(SeatStatus.NotAvailable);
            }
        }
        updateFlight.getSchedule(flight.getFlightNumber()).setFlightSeatWithFare(seats);
        flights.remove(flight);
        flights.add(updateFlight);
        return true;
    }
}
