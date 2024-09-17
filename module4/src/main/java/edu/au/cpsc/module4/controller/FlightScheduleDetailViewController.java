package edu.au.cpsc.module4.controller;

import edu.au.cpsc.module4.model.ScheduledFlight;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class FlightScheduleDetailViewController {

    @FXML
    private GridPane detailGrid;

    @FXML
    private TextField flightDesignatorTextField, departureAirportIdentityTextField, departureTimeTextField, arrivalAirportIdentityTextField, arrivalTimeTextField;

    @FXML
    public ToggleButton mondayButton, TuesdayButton, wednesdayButton, thursdayButton, fridayButton, saturdayButton, sundayButton;

    public void showScheduledFlight(ScheduledFlight sf) {
        if (sf == null) {
            flightDesignatorTextField.clear();
            departureAirportIdentityTextField.clear();
            departureTimeTextField.clear();
            arrivalAirportIdentityTextField.clear();
            arrivalTimeTextField.clear();
            return;
        }
        flightDesignatorTextField.setText(sf.getFlightDesignator());
        departureAirportIdentityTextField.setText(sf.getDepartureAirportIdent());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        departureTimeTextField.setText(sf.getDepartureTime().format(formatter));
        arrivalAirportIdentityTextField.setText(sf.getArrivalAirportIdent());
        arrivalTimeTextField.setText(sf.getArrivalTime().format(formatter));
        mondayButton.setSelected(sf.getDaysOfWeekFormatted().contains("M"));
        TuesdayButton.setSelected(sf.getDaysOfWeekFormatted().contains("T"));
        wednesdayButton.setSelected(sf.getDaysOfWeekFormatted().contains("W"));
        thursdayButton.setSelected(sf.getDaysOfWeekFormatted().contains("R"));
        fridayButton.setSelected(sf.getDaysOfWeekFormatted().contains("F"));
        saturdayButton.setSelected(sf.getDaysOfWeekFormatted().contains("S"));
        sundayButton.setSelected(sf.getDaysOfWeekFormatted().contains("U"));
    }

    public void updateScheduledFlight(ScheduledFlight sf) {
        sf.setFlightDesignator(flightDesignatorTextField.getText());
        sf.setDepartureAirportIdent(departureAirportIdentityTextField.getText());
        sf.setArrivalAirportIdent(arrivalAirportIdentityTextField.getText());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        if (!departureTimeTextField.getText().isEmpty()) {
            sf.setDepartureTime(LocalTime.parse(departureTimeTextField.getText(), formatter));
        }
        if (!arrivalTimeTextField.getText().isEmpty()) {
            sf.setArrivalTime(LocalTime.parse(arrivalTimeTextField.getText(), formatter));
        }
        HashSet<String> h = new HashSet<>();
        if (mondayButton.isSelected()) {h.add("monday");}
        if (TuesdayButton.isSelected()) {h.add("tuesday");}
        if (wednesdayButton.isSelected()) {h.add("wednesday");}
        if (thursdayButton.isSelected()) {h.add("thursday");}
        if (fridayButton.isSelected()) {h.add("friday");}
        if (saturdayButton.isSelected()) {h.add("saturday");}
        if (sundayButton.isSelected()) {h.add("sunday");}
        sf.setDaysOfWeek(h);
    }
}
