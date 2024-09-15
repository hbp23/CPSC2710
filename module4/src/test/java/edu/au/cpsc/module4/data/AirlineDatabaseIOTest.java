package edu.au.cpsc.module4.data;

import edu.au.cpsc.module4.model.ScheduledFlight;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class AirlineDatabaseIOTest {

    @Test
    void givenDatabaseWithScheduledFlightsWhenSavedAndLoadedThenAllScheduledFlightsInAirlineDatabase() throws IOException, ClassNotFoundException {
        AirlineDatabase db = new AirlineDatabase();
        String[] s = new String[] {"Monday", "Tuesday", "Wednesday"};
        HashSet<String> h = new HashSet<>(Arrays.asList(s));
        ScheduledFlight f = new ScheduledFlight("DL1331", "KPIT", LocalTime.of(8, 0, 15), "PPIT", LocalTime.of(8, 0, 15), h);
        ScheduledFlight z = new ScheduledFlight("EE4645", "PPIT", LocalTime.of(8, 15, 15), "TPIT", LocalTime.of(8, 15, 15), h);
        db.addScheduledFlight(f);
        db.addScheduledFlight(z);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        AirlineDatabaseIO.save(db, out);

        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        AirlineDatabase dbFromStream = AirlineDatabaseIO.load(in);
        assertEquals(2, dbFromStream.getScheduledFlights().size());
    }
}