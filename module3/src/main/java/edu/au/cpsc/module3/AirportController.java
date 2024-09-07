package edu.au.cpsc.module3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AirportController implements Initializable {

    @FXML
    private WebView webViewPane;

    @FXML
    protected void urlAction(Airport a) {
        String url = "https://www.windy.com/?" + (a.getLatitude()) + "," + (a.getLongitude()) + ",12";
        webViewPane.getEngine().load(url);
    }

    @FXML
    private HBox searchTools;

    @FXML
    private TextField identityTextField;

    @FXML
    protected void identityTextFieldAction() {
        iataTextField.clear();
        localTextField.clear();
        nameTextField.clear();
        typeTextField.clear();
        elevationTextField.clear();
        countryTextField.clear();
        regionTextField.clear();
        municipalityTextField.clear();
        String ident = identityTextField.getText();
        Airport a = AirportApplication.findAirportIdentity(ident);
        if (a != null) {
            if (a.getIataCode() != null) {
                iataTextField.setText(a.getIataCode());
            }
            if (a.getLocalCode() != null) {
                localTextField.setText(a.getLocalCode());
            }
            if (a.getAirportName() != null) {
                nameTextField.setText(a.getAirportName());
            }
            if (a.getAirportType() != null) {
                typeTextField.setText(a.getAirportType());
            }
            if (a.getElevationInFeet() != null) {
                elevationTextField.setText(Integer.toString(a.getElevationInFeet()));
            }
            if (a.getIsoCountry() != null) {
                countryTextField.setText(a.getIsoCountry());
            }
            if (a.getIsoRegion() != null) {
                regionTextField.setText(a.getIsoRegion());
            }
            if (a.getMunicipality() != null) {
                municipalityTextField.setText(a.getMunicipality());
            }
            urlAction(a);
        } else {
            iataTextField.clear();
            localTextField.clear();
            nameTextField.clear();
            typeTextField.clear();
            elevationTextField.clear();
            countryTextField.clear();
            regionTextField.clear();
            municipalityTextField.clear();
        }
    }

    @FXML
    private TextField iataTextField;

    @FXML
    protected void iataTextFieldAction() {
        identityTextField.clear();
        localTextField.clear();
        nameTextField.clear();
        typeTextField.clear();
        elevationTextField.clear();
        countryTextField.clear();
        regionTextField.clear();
        municipalityTextField.clear();
        String iata = iataTextField.getText();
        Airport a = AirportApplication.findAirportIata(iata);
        if (a != null) {
            if (a.getAirportIdentity() != null) {
                identityTextField.setText(a.getAirportIdentity());
            }
            if (a.getLocalCode() != null) {
                localTextField.setText(a.getLocalCode());
            }
            if (a.getAirportName() != null) {
                nameTextField.setText(a.getAirportName());
            }
            if (a.getAirportType() != null) {
                typeTextField.setText(a.getAirportType());
            }
            if (a.getElevationInFeet() != null) {
                elevationTextField.setText(Integer.toString(a.getElevationInFeet()));
            }
            if (a.getIsoCountry() != null) {
                countryTextField.setText(a.getIsoCountry());
            }
            if (a.getIsoRegion() != null) {
                regionTextField.setText(a.getIsoRegion());
            }
            if (a.getMunicipality() != null) {
                municipalityTextField.setText(a.getMunicipality());
            }
            urlAction(a);
        } else {
            identityTextField.clear();
            localTextField.clear();
            nameTextField.clear();
            typeTextField.clear();
            elevationTextField.clear();
            countryTextField.clear();
            regionTextField.clear();
            municipalityTextField.clear();
        }
    }

    @FXML
    private TextField localTextField;

    @FXML
    protected void localTextFieldAction() {
        iataTextField.clear();
        identityTextField.clear();
        nameTextField.clear();
        typeTextField.clear();
        elevationTextField.clear();
        countryTextField.clear();
        regionTextField.clear();
        municipalityTextField.clear();
        String local = localTextField.getText();
        Airport a = AirportApplication.findAirportLocal(local);
        if (a != null) {
            if (a.getIataCode() != null) {
                iataTextField.setText(a.getIataCode());
            }
            if (a.getAirportIdentity() != null) {
                identityTextField.setText(a.getAirportIdentity());
            }
            if (a.getAirportName() != null) {
                nameTextField.setText(a.getAirportName());
            }
            if (a.getAirportType() != null) {
                typeTextField.setText(a.getAirportType());
            }
            if (a.getElevationInFeet() != null) {
                elevationTextField.setText(Integer.toString(a.getElevationInFeet()));
            }
            if (a.getIsoCountry() != null) {
                countryTextField.setText(a.getIsoCountry());
            }
            if (a.getIsoRegion() != null) {
                regionTextField.setText(a.getIsoRegion());
            }
            if (a.getMunicipality() != null) {
                municipalityTextField.setText(a.getMunicipality());
            }
            urlAction(a);
        } else {
            iataTextField.clear();
            identityTextField.clear();
            nameTextField.clear();
            typeTextField.clear();
            elevationTextField.clear();
            countryTextField.clear();
            regionTextField.clear();
            municipalityTextField.clear();
        }
    }

    @FXML
    private Button searchButton;

    @FXML
    protected void searchButtonAction() {
        if (!identityTextField.getText().isEmpty()) {
            identityTextFieldAction();
        }
        else if (!iataTextField.getText().isEmpty()) {
            iataTextFieldAction();
        }
        else if (!localTextField.getText().isEmpty()) {
            localTextFieldAction();
        }
    }

    @FXML
    private VBox airportInfo;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField typeTextField;

    @FXML
    private TextField elevationTextField;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField regionTextField;

    @FXML
    private TextField municipalityTextField;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}