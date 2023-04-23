package com.sufiyandev.flight;

import java.util.List;

public class Flight implements Cloneable{
    private String flightNumber;
    private Airline company;
    private int seatCapacity;
    private List<Schedule> schedules;

    public Flight() {
    }

    public Flight(String flightNumber, Airline company, int seatCapacity, List<Schedule> schedules) {
        this.flightNumber = flightNumber;
        this.company = company;
        this.seatCapacity = seatCapacity;
        this.schedules = schedules;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public Schedule getSchedule(String flightNumber) {
        for (Schedule schedule: schedules) {
            if(schedule.getFlight().getFlightNumber() == flightNumber) {
                return schedule;
            }
        }
        return null;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airline getCompany() {
        return company;
    }

    public void setCompany(Airline company) {
        this.company = company;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Flight clone() {
        try {
            return (Flight) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
