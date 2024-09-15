package edu.au.cpsc.module4.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class ScheduledFlightTest {

    private ScheduledFlight f1;
    @BeforeEach
    void setUp() {
        f1 = new ScheduledFlight();
    }

    @Test
    void givenNewScheduledFlightThenGettersReturnConstructorArguments() {
        String[] s = new String[] {"Monday", "Tuesday", "Wednesday"};
        HashSet<String> h = new HashSet<>(Arrays.asList(s));
        f1 = new ScheduledFlight("DL1331", "KPIT", LocalTime.of(8, 0, 15), "PPIT", LocalTime.of(8, 0, 15), h);
        assertEquals("DL1331", f1.getFlightDesignator());
        assertEquals("KPIT", f1.getDepartureAirportIdent());
        assertEquals(LocalTime.of(8, 0, 15), f1.getDepartureTime());
        assertEquals("PPIT", f1.getArrivalAirportIdent());
        assertEquals(LocalTime.of(8, 0, 15), f1.getArrivalTime());
        assertEquals(h, f1.getDaysOfWeek());
    }

    @Test
    void givenNewScheduledFlightWhenFlightDesignatorSettersUsedThenGettersReturnSettersArguments() {
        f1.setFlightDesignator("DL1331");
        assertEquals("DL1331", f1.getFlightDesignator());
    }

    @Test
    void givenNewScheduledFlightWhenDepartureAirportIdentSetterUsedThenGettersReturnSettersArguments() {
        f1.setDepartureAirportIdent("KPIT");
        assertEquals("KPIT", f1.getDepartureAirportIdent());
    }

    @Test
    void givenNewScheduledFlightWhenDepartureTimeSetterUsedThenGettersReturnSettersArguments() {
        f1.setDepartureTime(LocalTime.of(8, 0, 15));
        assertEquals(LocalTime.of(8, 0, 15), f1.getDepartureTime());
    }

    @Test
    void givenNewScheduledFlightWhenArrivalAirportIdentSetterUsedThenGettersReturnSettersArguments() {
        f1.setArrivalAirportIdent("PPIT");
        assertEquals("PPIT", f1.getArrivalAirportIdent());
    }

    @Test
    void givenNewScheduledFlightWhenArrivalTimeSetterUsedThenGettersReturnSettersArguments() {
        f1.setArrivalTime(LocalTime.of(8, 0, 15));
        assertEquals(LocalTime.of(8, 0, 15), f1.getArrivalTime());
    }

    @Test
    void givenNewScheduledFlightWhenDaysOfWeekSetterUsedThenGettersReturnSettersArguments() {
        String[] s = new String[] {"Monday", "Tuesday", "Wednesday"};
        HashSet<String> h = new HashSet<>(Arrays.asList(s));
        f1.setDaysOfWeek(h);
        assertEquals(h, f1.getDaysOfWeek());
    }

    @Test
    void givenNewScheduledFlightWhenSettersAreNullThenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> f1.setFlightDesignator(null));
        assertThrows(IllegalArgumentException.class, () -> f1.setDepartureAirportIdent(null));
        assertThrows(IllegalArgumentException.class, () -> f1.setDepartureTime(null));
        assertThrows(IllegalArgumentException.class, () -> f1.setArrivalAirportIdent(null));
        assertThrows(IllegalArgumentException.class, () -> f1.setArrivalTime(null));
        assertThrows(IllegalArgumentException.class, () -> f1.setDaysOfWeek(null));
    }


}