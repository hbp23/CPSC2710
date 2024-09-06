package edu.au.cpsc.module3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class AirportController implements Initializable {

    @FXML
    private HBox searchTools;

    @FXML
    private VBox airportInfo;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField typeTextField;

    @FXML
    private TextField cityTextField;

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