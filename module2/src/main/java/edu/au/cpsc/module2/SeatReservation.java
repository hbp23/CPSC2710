public class SeatReservation {

    // fields
    private String flightDesignator;
    private java.time.LocalDate flightDate;
    private String firstName;
    private String lastName;

    // constructor
    public SeatReservation() {
        flightDesignator = null;
        flightDate = null;
        firstName = null;
        lastName = null;
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
        flightDate = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fn) {
        firstName = fn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String ln) {
        lastName = ln;
    }

    public String toString() {
        String output = "SeatReservation{flightDesignator=" + flightDesignator + ",flightDate=" + flightDate
                + ",firstName=" + firstName + ",lastName=" + lastName + "}";
        return output;
    }

}
