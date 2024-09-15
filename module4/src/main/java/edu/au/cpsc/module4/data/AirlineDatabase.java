package edu.au.cpsc.module4.data;


import edu.au.cpsc.module4.model.ScheduledFlight;

import java.util.ArrayList;
import java.util.List;

public class AirlineDatabase {

    // fields
    private List<ScheduledFlight> flights;

    // constructor
    public AirlineDatabase() {
        flights = new ArrayList<>();
    }

    // methods
    public List<ScheduledFlight> getScheduledFlights() {
        return flights;
    }

    public void addScheduledFlight(ScheduledFlight sf) {
        flights.add(sf);
    }

    public void removeScheduledFlight(ScheduledFlight sf) {
        flights.remove(sf);
    }

    public void updateScheduledFlight(ScheduledFlight sf) {

    }


}
