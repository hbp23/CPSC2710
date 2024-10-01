package edu.au.cpsc.module6.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.HashSet;

public class ScheduledFlight implements Serializable {

    // fields
    private String flightDesignator;
    private String departureAirportIdent;
    private LocalTime departureTime;
    private String arrivalAirportIdent;
    private LocalTime arrivalTime;
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

    public String getDaysOfWeekFormatted() {
        StringBuilder sb = new StringBuilder();
        if (daysOfWeek.contains("Monday") || daysOfWeek.contains("MONDAY") || daysOfWeek.contains("monday") || daysOfWeek.contains("M") || daysOfWeek.contains("m")) { sb.append("M");}
        if (daysOfWeek.contains("Tuesday") || daysOfWeek.contains("TUESDAY") || daysOfWeek.contains("tuesday") || daysOfWeek.contains("T") || daysOfWeek.contains("t")) { sb.append("T");}
        if (daysOfWeek.contains("Wednesday") || daysOfWeek.contains("WEDNESDAY") || daysOfWeek.contains("wednesday") || daysOfWeek.contains("W") || daysOfWeek.contains("w")) { sb.append("W");}
        if (daysOfWeek.contains("Thursday") || daysOfWeek.contains("THURSDAY") || daysOfWeek.contains("thursday") || daysOfWeek.contains("R") || daysOfWeek.contains("r")) { sb.append("R");}
        if (daysOfWeek.contains("Friday") || daysOfWeek.contains("FRIDAY") || daysOfWeek.contains("friday") || daysOfWeek.contains("F") || daysOfWeek.contains("f")) { sb.append("F");}
        if (daysOfWeek.contains("Saturday") || daysOfWeek.contains("SATURDAY") || daysOfWeek.contains("saturday") || daysOfWeek.contains("S") || daysOfWeek.contains("s")) { sb.append("S");}
        if (daysOfWeek.contains("Sunday") || daysOfWeek.contains("SUNDAY") || daysOfWeek.contains("sunday") || daysOfWeek.contains("U") || daysOfWeek.contains("u")) { sb.append("U");}
        return sb.toString();
    }

    @Override
    public String toString() {
        return "ScheduledFlight{" +
                "flightDesignator='" + flightDesignator + '\'' +
                ", departureAirportIdent='" + departureAirportIdent + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalAirportIdent='" + arrivalAirportIdent + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", daysOfWeek=" + daysOfWeek +
                '}';
    }

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
