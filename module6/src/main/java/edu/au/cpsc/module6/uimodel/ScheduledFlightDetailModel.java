package edu.au.cpsc.module6.uimodel;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class ScheduledFlightDetailModel {

    private final StringProperty flightDesignatorProperty;
    private final StringProperty departureAirportIdentProperty;
    private final StringProperty arrivalAirportIdentProperty;
    private final StringProperty departureTimeProperty;
    private final StringProperty arrivalTimeProperty;
    private final BooleanProperty mondayButtonProperty;
    private final BooleanProperty tuesdayButtonProperty;
    private final BooleanProperty wednesdayButtonProperty;
    private final BooleanProperty thursdayButtonProperty;
    private final BooleanProperty fridayButtonProperty;
    private final BooleanProperty saturdayButtonProperty;
    private final BooleanProperty sundayButtonProperty;
    private final BooleanProperty modifiedProperty;
    private final BooleanProperty newProperty;

    private final BooleanProperty isFlightDesignatorValid = new SimpleBooleanProperty(true);
    private final BooleanProperty isDepartureAirportIdentValid = new SimpleBooleanProperty(true);
    private final BooleanProperty isArrivalAirportIdentValid = new SimpleBooleanProperty(true);
    private final BooleanProperty isDepartureTimeValid = new SimpleBooleanProperty(true);
    private final BooleanProperty isArrivalTimeValid = new SimpleBooleanProperty(true);
    private final BooleanProperty isDaysOfWeekValid = new SimpleBooleanProperty(true);


    public ScheduledFlightDetailModel() {
        flightDesignatorProperty = new SimpleStringProperty();
        departureAirportIdentProperty = new SimpleStringProperty();
        arrivalAirportIdentProperty = new SimpleStringProperty();
        departureTimeProperty = new SimpleStringProperty();
        arrivalTimeProperty = new SimpleStringProperty();
        mondayButtonProperty = new SimpleBooleanProperty();
        tuesdayButtonProperty = new SimpleBooleanProperty();
        wednesdayButtonProperty = new SimpleBooleanProperty();
        thursdayButtonProperty = new SimpleBooleanProperty();
        fridayButtonProperty = new SimpleBooleanProperty();
        saturdayButtonProperty = new SimpleBooleanProperty();
        sundayButtonProperty = new SimpleBooleanProperty();
        modifiedProperty = new SimpleBooleanProperty();
        newProperty = new SimpleBooleanProperty();
        flightDesignatorProperty.addListener((observable, oldValue, newValue) -> setModified(true));
        departureAirportIdentProperty.addListener((observable, oldValue, newValue) -> setModified(true));
        arrivalAirportIdentProperty.addListener((observable, oldValue, newValue) -> setModified(true));
        departureTimeProperty.addListener((observable, oldValue, newValue) -> setModified(true));
        arrivalTimeProperty.addListener((observable, oldValue, newValue) -> setModified(true));
        mondayButtonProperty.addListener((observable, oldValue, newValue) -> setModified(true));
        tuesdayButtonProperty.addListener((observable, oldValue, newValue) -> setModified(true));
        wednesdayButtonProperty.addListener((observable, oldValue, newValue) -> setModified(true));
        thursdayButtonProperty.addListener((observable, oldValue, newValue) -> setModified(true));
        fridayButtonProperty.addListener((observable, oldValue, newValue) -> setModified(true));
        saturdayButtonProperty.addListener((observable, oldValue, newValue) -> setModified(true));
        sundayButtonProperty.addListener((observable, oldValue, newValue) -> setModified(true));
    }

    public StringProperty flightDesignatorProperty() { return flightDesignatorProperty; }
    public StringProperty departureAirportIdentProperty() { return departureAirportIdentProperty; }
    public StringProperty arrivalAirportIdentProperty() { return arrivalAirportIdentProperty; }
    public StringProperty departureTimeProperty() { return departureTimeProperty; }
    public StringProperty arrivalTimeProperty() { return arrivalTimeProperty; }
    public BooleanProperty mondayButtonProperty() { return mondayButtonProperty; }
    public BooleanProperty tuesdayButtonProperty() { return tuesdayButtonProperty; }
    public BooleanProperty wednesdayButtonProperty() { return wednesdayButtonProperty; }
    public BooleanProperty thursdayButtonProperty() { return thursdayButtonProperty; }
    public BooleanProperty fridayButtonProperty() { return fridayButtonProperty; }
    public BooleanProperty saturdayButtonProperty() { return saturdayButtonProperty; }
    public BooleanProperty sundayButtonProperty() { return sundayButtonProperty; }
    public BooleanProperty modifiedProperty() { return modifiedProperty; }
    public BooleanProperty newProperty() { return newProperty; }
    public BooleanProperty isFlightDesignatorValidProperty() { return isFlightDesignatorValid; }
    public BooleanProperty isDepartureAirportIdentValidProperty() { return isDepartureAirportIdentValid; }
    public BooleanProperty isArrivalAirportIdentValidProperty() { return isArrivalAirportIdentValid; }
    public BooleanProperty isDepartureTimeValidProperty() { return isDepartureTimeValid; }
    public BooleanProperty isArrivalTimeValidProperty() { return isArrivalTimeValid; }
    public BooleanProperty isDaysOfWeekValidProperty() { return isDaysOfWeekValid; }


    public String getFlightDesignator() { return flightDesignatorProperty.get(); }
    public void setFlightDesignator(String value) { flightDesignatorProperty.set(value); }
    public String getDepartureAirportIdent() { return departureAirportIdentProperty.get(); }
    public void setDepartureAirportIdent(String value) { departureAirportIdentProperty.set(value); }
    public String getArrivalAirportIdent() { return arrivalAirportIdentProperty.get(); }
    public void setArrivalAirportIdent(String value) { arrivalAirportIdentProperty.set(value); }
    public String getDepartureTime() { return departureTimeProperty.get(); }
    public void setDepartureTime(String value) { departureTimeProperty.set(value); }
    public String getArrivalTime() { return arrivalTimeProperty.get(); }
    public void setArrivalTime(String value) { arrivalTimeProperty.set(value); }
    public boolean isMondayButtonPressed() { return mondayButtonProperty.get(); }
    public void setMondayButtonPressed(boolean value) { mondayButtonProperty.set(value); }
    public boolean isTuesdayButtonPressed() { return tuesdayButtonProperty.get(); }
    public void setTuesdayButtonPressed(boolean value) { tuesdayButtonProperty.set(value); }
    public boolean isWednesdayButtonPressed() { return wednesdayButtonProperty.get(); }
    public void setWednesdayButtonPressed(boolean value) { wednesdayButtonProperty.set(value); }
    public boolean isThursdayButtonPressed() { return thursdayButtonProperty.get(); }
    public void setThursdayButtonPressed(boolean value) { thursdayButtonProperty.set(value); }
    public boolean isFridayButtonPressed() { return fridayButtonProperty.get(); }
    public void setFridayButtonPressed(boolean value) { fridayButtonProperty.set(value); }
    public boolean isSaturdayButtonPressed() { return saturdayButtonProperty.get(); }
    public void setSaturdayButtonPressed(boolean value) { saturdayButtonProperty.set(value); }
    public boolean isSundayButtonPressed() { return sundayButtonProperty.get(); }
    public void setSundayButtonPressed(boolean value) { sundayButtonProperty.set(value); }
    public boolean isModified() { return modifiedProperty.get(); }
    public void setModified(boolean value) { modifiedProperty.set(value); }
    public boolean isNew() { return newProperty.get();}
    public void setNew(boolean value) { newProperty.set(value); }

    public void validateFlightDesignator() {
        String fd = flightDesignatorProperty.get();
        isFlightDesignatorValid.set(fd != null && !fd.trim().isEmpty());
    }

    public void validateDepartureAirportIdent() {
        String dai = departureAirportIdentProperty.get();
        isDepartureAirportIdentValid.set(dai != null && !dai.trim().isEmpty());
    }

    public void validateArrivalAirportIdent() {
        String aai = arrivalAirportIdentProperty.get();
        isArrivalAirportIdentValid.set(aai != null && !aai.trim().isEmpty());
    }

    public void validateDepartureTime() {
        String dt = departureTimeProperty.get();
        isDepartureTimeValid.set(dt != null && !dt.trim().isEmpty() && validateTimeField(dt));
    }

    public void validateArrivalTime() {
        String at = arrivalTimeProperty.get();
        isArrivalTimeValid.set(at != null && !at.trim().isEmpty() && validateTimeField(at));
    }

    public void validateDaysOfWeek() {
        isDaysOfWeekValid.set(isMondayButtonPressed() || isTuesdayButtonPressed() || isWednesdayButtonPressed()
                || isThursdayButtonPressed() || isFridayButtonPressed()
                || isSaturdayButtonPressed() || isSundayButtonPressed());
    }

    private boolean validateTimeField(String t) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        try {
            LocalTime.parse(t, formatter);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
}
