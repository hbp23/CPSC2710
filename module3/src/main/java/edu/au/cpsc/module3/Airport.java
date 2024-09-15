package edu.au.cpsc.module3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Airport {

    // Fields
    protected String airportIdentity;
    protected String airportType;
    protected String airportName;
    protected Integer elevationInFeet;
    protected String airportContinent;
    protected String isoCountry;
    protected String isoRegion;
    protected String municipality;
    protected String gpsCode;
    protected String iataCode;
    protected String localCode;
    protected Double longitude;
    protected Double latitude;

    // Constructor

    public Airport(String airportIdentity, String airportType, String airportName, Integer elevationInFeet, String airportContinent, String isoCountry, String isoRegion, String municipality, String gpsCode, String iataCode, String localCode, Double longitude, Double latitude) {
        this.airportIdentity = airportIdentity;
        this.airportType = airportType;
        this.airportName = airportName;
        this.elevationInFeet = elevationInFeet;
        this.airportContinent = airportContinent;
        this.isoCountry = isoCountry;
        this.isoRegion = isoRegion;
        this.municipality = municipality;
        this.gpsCode = gpsCode;
        this.iataCode = iataCode;
        this.localCode = localCode;
        this.longitude = longitude;
        this.latitude = latitude;
    }


    // Methods

    public static List<Airport> readAll(String fileName) throws IOException {
        List<Airport> airports = new ArrayList<>();

        // Loads the csv file from resources directory
        InputStream inputStream = Airport.class.getClassLoader().getResourceAsStream(fileName);

        if (inputStream == null) {
            System.err.println("Couldn't find file: " + fileName);
            return airports;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                // Skips the first line of CSV
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Splits the line by commas and creates an Airport object
                String[] tokens = line.split(",");
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].isEmpty()) {
                        tokens[i] = null;
                    }
                }
                String airportIdentity = tokens[0];
                String airportType = tokens[1];
                String airportName = tokens[2];
                Integer elevationInFeet;
                if (tokens[3] == null) {
                    elevationInFeet = null;
                } else {
                    elevationInFeet = Integer.valueOf(tokens[3]);
                }
                String airportContinent = tokens[4];
                String isoCountry = tokens[5];
                String isoRegion = tokens[6];
                String municipality = tokens[7];
                String gpsCode = tokens[8];
                String iataCode = tokens[9];
                String localCode = tokens[10];
                Double longitude;
                if (tokens[11] == null) {
                    longitude = null;
                } else {
                    longitude = Double.valueOf(tokens[11]);
                }
                Double latitude;
                if (tokens[12] == null) {
                    latitude = null;
                } else {
                    latitude = Double.valueOf(tokens[12]);
                }

                // Adds the Airport object to the list
                Airport airport = new Airport(airportIdentity, airportType, airportName, elevationInFeet, airportContinent, isoCountry, isoRegion, municipality, gpsCode, iataCode, localCode, longitude, latitude);
                airports.add(airport);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return airports;
    }

    // all getters and setters

    public String getAirportIdentity() {
        return airportIdentity;
    }

    public void setAirportIdentity(String airportIdentity) {
        airportIdentity = airportIdentity;
    }

    public String getAirportType() {
        return airportType;
    }

    public void setAirportType(String airportType) {
        this.airportType = airportType;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public Integer getElevationInFeet() {
        return elevationInFeet;
    }

    public void setElevationInFeet(Integer elevationInFeet) {
        this.elevationInFeet = elevationInFeet;
    }

    public String getAirportContinent() {
        return airportContinent;
    }

    public void setAirportContinent(String airportContinent) {
        this.airportContinent = airportContinent;
    }

    public String getIsoCountry() {
        return isoCountry;
    }

    public void setIsoCountry(String isoCountry) {
        this.isoCountry = isoCountry;
    }

    public String getIsoRegion() {
        return isoRegion;
    }

    public void setIsoRegion(String isoRegion) {
        this.isoRegion = isoRegion;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getGpsCode() {
        return gpsCode;
    }

    public void setGpsCode(String gpsCode) {
        this.gpsCode = gpsCode;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getLocalCode() {
        return localCode;
    }

    public void setLocalCode(String localCode) {
        this.localCode = localCode;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    // toString method
    @Override
    public String toString() {
        return "Airport{ident=" + airportIdentity + "/type="
                + airportType + "/name=" + airportName + "/elevationft=" + elevationInFeet
                + "/continent=" + airportContinent + "/iso_country=" + isoCountry
                + "/iso_region=" + isoRegion + "/municipality=" + municipality
                + "/gps_code=" + gpsCode + "/iata_code=" + iataCode
                + "/local_code=" + localCode + "/coordinates=" + latitude + "," + longitude + "}";
    }

    /*public static void main(String[] args) throws IOException {
        String fn = "airport-codes.csv";
        List<Airport> airports = readAll(fn);

        for (Airport a : airports) {
            System.out.println(a);
        }
    }*/
}
