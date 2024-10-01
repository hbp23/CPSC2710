package edu.au.cpsc.module6.controller;

import edu.au.cpsc.module6.model.ScheduledFlight;
import edu.au.cpsc.module6.uimodel.ScheduledFlightDetailModel;
import javafx.beans.value.WritableDoubleValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class FlightScheduleDetailViewController {

    @FXML
    private TextField flightDesignatorTextField, departureAirportIdentityTextField, departureTimeTextField, arrivalAirportIdentityTextField, arrivalTimeTextField;

    @FXML
    private ToggleButton mondayButton, TuesdayButton, wednesdayButton, thursdayButton, fridayButton, saturdayButton, sundayButton;

    @FXML
    private Label buttonLabel;

    private ScheduledFlightDetailModel model;

    public void initialize() {
        model = new ScheduledFlightDetailModel();
        flightDesignatorTextField.textProperty().bindBidirectional(model.flightDesignatorProperty());
        departureAirportIdentityTextField.textProperty().bindBidirectional(model.departureAirportIdentProperty());
        departureTimeTextField.textProperty().bindBidirectional(model.departureTimeProperty());
        arrivalAirportIdentityTextField.textProperty().bindBidirectional(model.arrivalAirportIdentProperty());
        arrivalTimeTextField.textProperty().bindBidirectional(model.arrivalTimeProperty());
        mondayButton.selectedProperty().bindBidirectional(model.mondayButtonProperty());
        TuesdayButton.selectedProperty().bindBidirectional(model.tuesdayButtonProperty());
        wednesdayButton.selectedProperty().bindBidirectional(model.wednesdayButtonProperty());
        thursdayButton.selectedProperty().bindBidirectional(model.thursdayButtonProperty());
        fridayButton.selectedProperty().bindBidirectional(model.fridayButtonProperty());
        saturdayButton.selectedProperty().bindBidirectional(model.saturdayButtonProperty());
        sundayButton.selectedProperty().bindBidirectional(model.sundayButtonProperty());

        flightDesignatorTextField.textProperty().addListener((observable, oldValue, newValue) -> {model.validateFlightDesignator();});
        departureAirportIdentityTextField.textProperty().addListener((observable, oldValue, newValue) -> {model.validateDepartureAirportIdent();});
        departureTimeTextField.textProperty().addListener((observable, oldValue, newValue) -> {model.validateDepartureTime();});
        arrivalAirportIdentityTextField.textProperty().addListener((observable, oldValue, newValue) -> {model.validateArrivalAirportIdent();});
        arrivalTimeTextField.textProperty().addListener((observable, oldValue, newValue) -> {model.validateArrivalTime();});
        mondayButton.selectedProperty().addListener((observable, wasValid, isValid) -> {model.validateDaysOfWeek();});
        TuesdayButton.selectedProperty().addListener((observable, wasValid, isValid) -> {model.validateDaysOfWeek();});
        wednesdayButton.selectedProperty().addListener((observable, wasValid, isValid) -> {model.validateDaysOfWeek();});
        thursdayButton.selectedProperty().addListener((observable, wasValid, isValid) -> {model.validateDaysOfWeek();});
        fridayButton.selectedProperty().addListener((observable, wasValid, isValid) -> {model.validateDaysOfWeek();});
        saturdayButton.selectedProperty().addListener((observable, wasValid, isValid) -> {model.validateDaysOfWeek();});
        sundayButton.selectedProperty().addListener((observable, wasValid, isValid) -> {model.validateDaysOfWeek();});

        model.isFlightDesignatorValidProperty().addListener((observable, wasValid, isValid) -> {
            if (!isValid) {
                errorField(flightDesignatorTextField);
            } else {
                flightDesignatorTextField.setEffect(null);
            }
        });
        model.isDepartureAirportIdentValidProperty().addListener((observable, wasValid, isValid) -> {
            if (!isValid) {
                errorField(departureAirportIdentityTextField);
            } else {
                departureAirportIdentityTextField.setEffect(null);
            }
        });
        model.isArrivalAirportIdentValidProperty().addListener((observable, wasValid, isValid) -> {
            if (!isValid) {
                errorField(arrivalAirportIdentityTextField);
            } else {
                arrivalAirportIdentityTextField.setEffect(null);
            }
        });
        model.isDepartureTimeValidProperty().addListener((observable, wasValid, isValid) -> {
            if (!isValid) {
                errorField(departureTimeTextField);
            } else {
                departureTimeTextField.setEffect(null);
            }
        });
        model.isArrivalTimeValidProperty().addListener((observable, wasValid, isValid) -> {
            if (!isValid) {
                errorField(arrivalTimeTextField);
            } else {
                arrivalTimeTextField.setEffect(null);
            }
        });
        model.isDaysOfWeekValidProperty().addListener((observable, wasValid, isValid) -> {
            if (!isValid) {
                buttonLabel.setTextFill(Color.RED);
            } else {
                buttonLabel.setTextFill(Color.BLACK);
            }
        });
    }

    public ScheduledFlightDetailModel getModel() {
        return model;
    }

    public void showScheduledFlight(ScheduledFlight sf) {
        if (sf == null) {
            model.setFlightDesignator("");
            model.setDepartureAirportIdent("");
            model.setDepartureTime("");
            model.setArrivalAirportIdent("");
            model.setArrivalTime("");
            model.setMondayButtonPressed(false);
            model.setTuesdayButtonPressed(false);
            model.setWednesdayButtonPressed(false);
            model.setThursdayButtonPressed(false);
            model.setFridayButtonPressed(false);
            model.setSaturdayButtonPressed(false);
            model.setSundayButtonPressed(false);
            model.setModified(false);
            model.setNew(true);
            return;
        }
        model.setFlightDesignator(sf.getFlightDesignator());
        model.setDepartureAirportIdent(sf.getDepartureAirportIdent());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        model.setDepartureTime(sf.getDepartureTime().format(formatter));
        model.setArrivalAirportIdent(sf.getArrivalAirportIdent());
        model.setArrivalTime(sf.getArrivalTime().format(formatter));
        model.setMondayButtonPressed(sf.getDaysOfWeekFormatted().contains("M"));
        model.setTuesdayButtonPressed(sf.getDaysOfWeekFormatted().contains("T"));
        model.setWednesdayButtonPressed(sf.getDaysOfWeekFormatted().contains("W"));
        model.setThursdayButtonPressed(sf.getDaysOfWeekFormatted().contains("R"));
        model.setFridayButtonPressed(sf.getDaysOfWeekFormatted().contains("F"));
        model.setSaturdayButtonPressed(sf.getDaysOfWeekFormatted().contains("S"));
        model.setSundayButtonPressed(sf.getDaysOfWeekFormatted().contains("U"));
        model.setModified(false);
        model.setNew(false);
    }

    public boolean updateScheduledFlight(ScheduledFlight sf) {
        if (!validateInputs()) return false;
        sf.setFlightDesignator(model.getFlightDesignator());
        sf.setDepartureAirportIdent(model.getDepartureAirportIdent());
        sf.setArrivalAirportIdent(model.getArrivalAirportIdent());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        if (!model.getDepartureTime().isEmpty()) {
            sf.setDepartureTime(LocalTime.parse(model.getDepartureTime(), formatter));
        }
        if (!model.getArrivalTime().isEmpty()) {
            sf.setArrivalTime(LocalTime.parse(model.getArrivalTime(), formatter));
        }
        HashSet<String> h = new HashSet<>();
        if (model.isMondayButtonPressed()) {h.add("monday");}
        if (model.isTuesdayButtonPressed()) {h.add("tuesday");}
        if (model.isWednesdayButtonPressed()) {h.add("wednesday");}
        if (model.isThursdayButtonPressed()) {h.add("thursday");}
        if (model.isFridayButtonPressed()) {h.add("friday");}
        if (model.isSaturdayButtonPressed()) {h.add("saturday");}
        if (model.isSundayButtonPressed()) {h.add("sunday");}
        sf.setDaysOfWeek(h);
        return true;
    }

    private void errorField(TextField field) {
        DropShadow glow = new DropShadow();
        glow.setColor(Color.RED);
        glow.setRadius(5);
        glow.setSpread(0.3);
        field.setEffect(glow);
    }

    public boolean validateInputs() {
        model.validateFlightDesignator();
        model.validateDepartureAirportIdent();
        model.validateArrivalAirportIdent();
        model.validateDepartureTime();
        model.validateArrivalTime();
        model.validateDaysOfWeek();

        return model.isFlightDesignatorValidProperty().get() &&
                model.isDepartureAirportIdentValidProperty().get() &&
                model.isArrivalAirportIdentValidProperty().get() &&
                model.isDepartureTimeValidProperty().get() &&
                model.isArrivalTimeValidProperty().get() &&
                model.isDaysOfWeekValidProperty().get();
    }
}
