package edu.au.cpsc.module4.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.HashSet;

public class ScheduledFlight implements Serializable {

    // fields
    private String flightDesignator;
    private String departureAirportIdent;
    private java.time.LocalTime departureTime;
    private String arrivalAirportIdent;
    private java.time.LocalTime arrivalTime;
    private HashSet<String> daysOfWeek;

    // constructors
    public ScheduledFlight(String flightDesignator, String departureAirportIdent, LocalTime departureTime, String arrivalAirportIdent, LocalTime arrivalTime, HashSet<String> daysOfWeek) {
        this.flightDesignator = flightDesignator;
        this.departureAirportIdent = departureAirportIdent;
        this.departureTime = departureTime;
        this.arrivalAirportIdent = arrivalAirportIdent;
        this.arrivalTime = arrivalTime;
        this.daysOfWeek = daysOfWeek;
    }

    public ScheduledFlight() {}

    // methods

        // getters and setters

    public String getFlightDesignator() {
        return flightDesignator;
    }

    public void setFlightDesignator(String flightDesignator) {
        if (flightDesignator == null) {
            throw new IllegalArgumentException("flightDesignator cannot be null");
        }
        this.flightDesignator = flightDesignator;
    }

    public String getDepartureAirportIdent() {
        return departureAirportIdent;
    }

    public void setDepartureAirportIdent(String departureAirportIdent) {
        if (departureAirportIdent == null) {
            throw new IllegalArgumentException("departureAirportIdent cannot be null");
        }
        this.departureAirportIdent = departureAirportIdent;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        if (departureTime == null) {
            throw new IllegalArgumentException("departureTime cannot be null");
        }
        this.departureTime = departureTime;
    }

    public String getArrivalAirportIdent() {
        return arrivalAirportIdent;
    }

    public void setArrivalAirportIdent(String arrivalAirportIdent) {
        if (arrivalAirportIdent == null) {
            throw new IllegalArgumentException("arrivalAirportIdent cannot be null");
        }
        this.arrivalAirportIdent = arrivalAirportIdent;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        if (arrivalTime == null) {
            throw new IllegalArgumentException("arrivalTime cannot be null");
        }
        this.arrivalTime = arrivalTime;
    }

    public HashSet<String> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(HashSet<String> daysOfWeek) {
        if (daysOfWeek == null) {
            throw new IllegalArgumentException("daysOfWeek cannot be null");
        }
        this.daysOfWeek = daysOfWeek;
    }
}
