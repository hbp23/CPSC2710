package edu.au.cpsc.module6.sampledata;

import edu.au.cpsc.module6.data.dbManager;
import edu.au.cpsc.module6.model.ScheduledFlight;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;

public class ScheduledFlightGenerator {

    public static void main (String[] args) {
        ScheduledFlight f1 =  new ScheduledFlight("DL1331", "KPIT", LocalTime.of(8, 0), "PPIT", LocalTime.of(8, 0, 15), new HashSet<>(Arrays.asList(new String[] {"Monday", "Tuesday", "Wednesday"})));
        ScheduledFlight f2 = new  ScheduledFlight("EE4645", "PPIT", LocalTime.of(8, 15), "TPIT", LocalTime.of(8, 15, 15), new HashSet<>(Arrays.asList(new String[] {"Monday", "Tuesday", "Wednesday"})));
        dbManager.getDataBase().addScheduledFlight(f1);
        dbManager.getDataBase().addScheduledFlight(f2);
        dbManager.saveDatabase();
    }
}
