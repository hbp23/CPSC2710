package edu.au.cpsc.module2;

public class SeatReservation {

    // fields
    private String flightDesignator;
    private java.time.LocalDate flightDate;
    private String firstName;
    private String lastName;
    private int numberOfBags;
    private boolean flyingWithInfant;

    // constructors
    public SeatReservation() {
        flightDesignator = null;
        flightDate = null;
        firstName = null;
        lastName = null;
        numberOfBags = 0;
        flyingWithInfant = false;
    }

    public SeatReservation(String flightDesignator, java.time.LocalDate flightDate, String firstName,
                           String lastName, int numberOfBags, boolean flyingWithInfant) {
        setFlightDesignator(flightDesignator);
        setFlightDate(flightDate);
        setFirstName(firstName);
        setLastName(lastName);
        setNumberOfBags(numberOfBags);
        if (flyingWithInfant) {
            makeFlyingWithInfant();
        }
        else {
            makeNotFlyingWithInfant();
        }
    }

    // methods
    public String getFlightDesignator() {
        return flightDesignator;
    }

    public void setFlightDesignator(String fd) {
        if (fd == null) {
            throw new IllegalArgumentException("Flight Designator cannot be null");
        }
        int l = fd.length();
        if (l < 4 || l > 6) {
            throw new IllegalArgumentException("Invalid Flight Designator character length");
        }
        flightDesignator = fd;
    }

    public java.time.LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(java.time.LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Flight Date cannot be null");
        }
        flightDate = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fn) {
        if (fn == null) {
            throw new IllegalArgumentException("First Name cannot be null");
        }
        firstName = fn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String ln) {
        if (ln == null) {
            throw new IllegalArgumentException("Last Name cannot be null");
        }
        lastName = ln;
    }

    public int getNumberOfBags() { return numberOfBags; }

    public void setNumberOfBags(int nb) { numberOfBags = nb; }

    public boolean isFlyingWithInfant() { return flyingWithInfant; }

    public void makeFlyingWithInfant() { flyingWithInfant = true; }

    public void makeNotFlyingWithInfant() { flyingWithInfant = false; }

    public String toString() {
        String output = "SeatReservation{flightDesignator=" + flightDesignator + ",flightDate=" + flightDate
                + ",firstName=" + firstName + ",lastName=" + lastName + ",numberOfBags=" + numberOfBags
                + ",flyingWithInfant=" + flyingWithInfant + "}";
        return output;
    }

}
