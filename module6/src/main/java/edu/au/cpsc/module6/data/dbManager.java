package edu.au.cpsc.module6.data;

import java.io.*;

public class dbManager {

    public static final File DEFAULT_FILE = new File("airlines.dat");

    private static AirlineDatabase db = null;

    public static AirlineDatabase getDataBase() {
        if (db == null) {
            db = loadDatabase();
        }
        return db;
    }

    private static AirlineDatabase loadDatabase() {
        try (InputStream is = new FileInputStream(DEFAULT_FILE)) {
            return AirlineDatabaseIO.load(is);
        } catch (IOException|ClassNotFoundException e) {
            return new AirlineDatabase();
        }
    }

    public static void saveDatabase() {
        try (OutputStream os = new FileOutputStream(DEFAULT_FILE)) {
            AirlineDatabaseIO.save(getDataBase(), os);
        } catch (IOException e) {
            System.err.println("Error saving database: " + DEFAULT_FILE);
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
