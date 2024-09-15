package edu.au.cpsc.module3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirportApplication extends Application {

    private static List<Airport> airportList;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AirportApplication.class.getResource("Airport-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Airport Locator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        // gets the list
        airportList = Airport.readAll("airport-codes.csv");
        launch();
    }

    protected static Airport findAirportIdentity(String ident) {
        for (Airport a : airportList) {
            if (ident.equalsIgnoreCase(a.getAirportIdentity())) {
                return a;
            }
        }
        return null;
    }

    protected static Airport findAirportIata(String iata) {
        for (Airport a : airportList) {
            if (iata.equalsIgnoreCase(a.getIataCode())) {
                return a;
            }
        }
        return null;
    }

    protected static Airport findAirportLocal(String local) {
        for (Airport a : airportList) {
            if (local.equalsIgnoreCase(a.getLocalCode())) {
                return a;
            }
        }
        return null;
    }
}