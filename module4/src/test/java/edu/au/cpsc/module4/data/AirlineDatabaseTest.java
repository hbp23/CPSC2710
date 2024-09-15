package edu.au.cpsc.module4.data;

import edu.au.cpsc.module4.model.ScheduledFlight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class AirlineDatabaseTest {

    private AirlineDatabase db;
    private ScheduledFlight f;
    private ScheduledFlight z;

    @BeforeEach
    void setUp() {
        db = new AirlineDatabase();
        String[] s = new String[] {"Monday", "Tuesday", "Wednesday"};
        HashSet<String> h = new HashSet<>(Arrays.asList(s));
        f = new ScheduledFlight("DL1331", "KPIT", LocalTime.of(8, 0, 15), "PPIT", LocalTime.of(8, 0, 15), h);
        z = new ScheduledFlight("EE4645", "PPIT", LocalTime.of(8, 15, 15), "TPIT", LocalTime.of(8, 15, 15), h);
    }

    @Test
    void givenNewDatabaseThenNoScheduledFlights() {
        assertEquals(0, db.getScheduledFlights().size());
    }

    @Test
    void givenNewDatabaseWhenScheduledFlightAddedThenOneScheduledFlight() {
        db = new AirlineDatabase();
        db.addScheduledFlight(f);
        assertEquals(1, db.getScheduledFlights().size());
    }

    @Test
    void givenNewDatabaseWhenScheduledFlightAddedThenScheduledFlightInAirlineDatabase() {
        db = new AirlineDatabase();
        db.addScheduledFlight(f);
        assertTrue(db.getScheduledFlights().contains(f));
    }

    @Test
    void givenNewDatabaseWhenScheduledFlightAddedThenDifferentScheduledFlightNotInAirlineDatabase() {
        db = new AirlineDatabase();
        db.addScheduledFlight(f);
        assertFalse(db.getScheduledFlights().contains(z));
    }

    @Test
    void givenNewDatabaseWhenTwoScheduledFlightsAddedThenBothInAirlineDatabase() {
        db.addScheduledFlight(f);
        db.addScheduledFlight(z);
        assertTrue(db.getScheduledFlights().contains(f));
        assertTrue(db.getScheduledFlights().contains(z));
    }

    @Test
    void givenNewDatabaseWithTwoScheduledFlightsWhenScheduledFlightRemovedThenNotInAirlineDatabase() {
        db.addScheduledFlight(f);
        db.addScheduledFlight(z);
        db.removeScheduledFlight(z);
        assertFalse(db.getScheduledFlights().contains(z));
    }

    @Test
    void givenDatabaseWithTwoScheduledFlightsWhenAirlineDatabaseUpdatedThenModifiedScheduledFlightInAirlineDatabase() {
        db.addScheduledFlight(f);
        db.addScheduledFlight(z);
        f.setFlightDesignator("DL0011");
        db.updateScheduledFlight(f);
        ScheduledFlight f2 = null;
        for (ScheduledFlight s : db.getScheduledFlights()) {
            if (s.getDepartureAirportIdent().equals("KPIT")) {
                f2 = s;
            }
        }
        assertNotNull(f2);
        assertEquals("DL0011", f2.getFlightDesignator());

    }


}