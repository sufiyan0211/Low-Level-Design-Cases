package com.sufiyandev;

import com.sufiyandev.bookingSystem.BookingSystem;
import com.sufiyandev.flight.*;
import com.sufiyandev.flight.dao.Flights;
import com.sufiyandev.user.Gender;
import com.sufiyandev.user.Nationality;
import com.sufiyandev.user.User;
import com.sufiyandev.user.UserBuilder;
import com.sufiyandev.user.dao.Users;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Add 3 Users {sofiyan, shrey, riya}
        User sofiyan = new UserBuilder()
                .setName("Sofiyan")
                .setAge(23)
                .setUserId("sufiyan0211")
                .setNationality(Nationality.India)
                .setGender(Gender.Male)
                .build();

        User shrey = new UserBuilder()
                .setName("Shrey")
                .setGender(Gender.Male)
                .setAge(28)
                .setUserId("Shrey021")
                .setNationality(Nationality.India)
                .build();

        User riya = new UserBuilder()
                .setName("Riya")
                .setGender(Gender.Female)
                .setAge(24)
                .setUserId("Riya021")
                .setNationality(Nationality.India)
                .build();

        Users usersDao = new Users();
        usersDao.saveUser(sofiyan);
        usersDao.saveUser(shrey);
        usersDao.saveUser(riya);


        /**
         * Create 3 flights
         * 1: { Pune to Goa }
         * 2: { pune to Mumbai }
         * 3: { Chennai to Goa }
         */

        Location puneLocation = new Location("Pune");
        Location goalLocation = new Location("Goa");
        Location chennaiLocation = new Location("Chennai");
        Location mumbaiLocation = new Location("Mumbai");

        Airline airIndia = new Airline("Air India");
        Airline indiGo = new Airline("IndiGo");
        Airline spiceJet = new Airline("SpiceJet");

        Airport puneAirport = new Airport("Pune", puneLocation);
        Airport goaAirport = new Airport("Goa", goalLocation);
        Airport chennaiAirport = new Airport("Chennai", chennaiLocation);
        Airport mumbaiAirport = new Airport("Mumbai", mumbaiLocation);


        String arrivalDateTimeStr = "2021-10-20 10:50:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(arrivalDateTimeStr, formatter);
        Timestamp arrivalTime = Timestamp.valueOf(dateTime);

        String destinationDateTimeStr = "2021-10-20 12:10:00";
        dateTime = LocalDateTime.parse(destinationDateTimeStr, formatter);
        Timestamp destinationTime = Timestamp.valueOf(dateTime);

        Flight flight1 = new Flight();
        flight1.setFlightNumber("1");
        flight1.setCompany(airIndia);
        flight1.setSeatCapacity(100);

        Schedule schedule1 = new ScheduleBuilder()
                .setFlight(flight1)
                .setFlight(flight1)
                .setArrivalAirport(puneAirport)
                .setDestinationAirport(goaAirport)
                .setArrivalTime(arrivalTime)
                .setDestinationTime(destinationTime)
                .setFlightStatus(FlightStatus.OnTime)
                .build();
        schedule1.setFlightSeatWithFare();

        List<Schedule> schedules1 = new ArrayList<>();
        schedules1.add(schedule1);
        flight1.setSchedules(schedules1);


        Flight flight2 = new Flight();
        flight2.setFlightNumber("2");
        flight2.setCompany(indiGo);
        flight2.setSeatCapacity(100);

        Schedule schedule2 = new ScheduleBuilder()
                .setFlight(flight2)
                .setFlight(flight2)
                .setArrivalAirport(puneAirport)
                .setDestinationAirport(mumbaiAirport)
                .setArrivalTime(arrivalTime)
                .setDestinationTime(destinationTime)
                .setFlightStatus(FlightStatus.OnTime)
                .build();
        schedule2.setFlightSeatWithFare();

        List<Schedule> schedules2 = new ArrayList<>();
        schedules2.add(schedule2);
        flight2.setSchedules(schedules2);


        Flight flight3 = new Flight();
        flight3.setFlightNumber("3");
        flight3.setCompany(spiceJet);
        flight3.setSeatCapacity(100);

        Schedule schedule3 = new ScheduleBuilder()
                .setFlight(flight3)
                .setFlight(flight3)
                .setArrivalAirport(chennaiAirport)
                .setDestinationAirport(goaAirport)
                .setArrivalTime(arrivalTime)
                .setDestinationTime(destinationTime)
                .setFlightStatus(FlightStatus.OnTime)
                .build();
        schedule3.setFlightSeatWithFare();

        List<Schedule> schedules3 = new ArrayList<>();
        schedules3.add(schedule3);
        flight3.setSchedules(schedules3);

        Flights flights = new Flights();
        flights.saveFlight(flight1);
        flights.saveFlight(flight2);
        flights.saveFlight(flight3);


        BookingSystem bookingSystem = new BookingSystem();
        bookingSystem.setUsers(usersDao.getUsers());
        bookingSystem.setFlights(flights.getFlights());


        bookingSystem.bookFlight(sofiyan, puneLocation, goalLocation, arrivalTime, 20);
        bookingSystem.bookFlight(shrey, puneLocation, mumbaiLocation, arrivalTime, 30);
        bookingSystem.bookFlight(riya, chennaiLocation, goalLocation, arrivalTime, 40);

        // test
        bookingSystem.getFlights();

    }
}